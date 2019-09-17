package com.lukoseviciute.programming.util;


import com.lukoseviciute.programming.models.Athlete;

import java.sql.ResultSet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Athlete> getAthletes() throws SQLException{

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from hammer_women");

        List<Athlete> athletes = new ArrayList<>();

        while (resultSet.next()){
            int rank = resultSet.getInt(2);
            String mark = resultSet.getString(3);
            String name = resultSet.getString(4);
            String date = resultSet.getString(5);
            String location = resultSet.getString(6);

            athletes.add(new Athlete(rank, mark, name, date, location));
        }

        resultSet.close();
        conn.close();
        return athletes;

    }

}
