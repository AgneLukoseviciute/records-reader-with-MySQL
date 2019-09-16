package com.lukoseviciute.programming;

import com.lukoseviciute.programming.util.CompareAll;
import com.lukoseviciute.programming.util.GetConfigValues;
import com.lukoseviciute.programming.util.PrintDifferences;

import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {

        //reading config.properties
        GetConfigValues properties = new GetConfigValues();
        properties.getValues();

        //TODO: use builder design pattern.
        CompareAll comparator = new CompareAll("assets/records.csv", "assets/records_tweaked.json", "assets/records_tweaked.xml");
        comparator.compare();//return mismatch list
        PrintDifferences.printDiffs(comparator.getDiffsArr());

        String url = "jdbc:mysql://localhost:3306/athletes1?useTimezone=true&serverTimezone=UTC";
        String username = properties.getUserName();
        String password = properties.getPassword();
        
        System.out.println("Connecting database...");

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Statement stmt = conn.createStatement();
            String strSelect = "select athlete_name, mark, location from hammer_women";
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                String mark = rset.getString("mark");
                String athlete_name = rset.getString("athlete_name");
                String location   = rset.getString("location");
                System.out.println(mark + ", " + athlete_name + ", " + location);
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

}

