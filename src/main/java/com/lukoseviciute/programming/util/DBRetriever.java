package com.lukoseviciute.programming.util;


import java.io.IOException;
import java.sql.*;

public class DBRetriever {

    private String url;
    private String username;
    private String password;

    public DBRetriever() throws IOException {

        //reading config.properties
        GetConfigValues properties = new GetConfigValues();
        properties.getValues();

        url = "jdbc:mysql://localhost:3306/athletes1?useTimezone=true&serverTimezone=UTC";
        username = properties.getUserName();
        password = properties.getPassword();

    }

    public ResultSet getQueryResult() throws SQLException {
        System.out.println("Connecting database...");

        try(Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Statement stmt = conn.createStatement();
            String strSelect = "select * from hammer_women";
            ResultSet rset = stmt.executeQuery(strSelect);

            return rset;

        } catch(
                SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }


}
