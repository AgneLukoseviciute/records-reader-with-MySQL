package com.lukoseviciute.programming.util;


import com.lukoseviciute.programming.models.Athlete;

import java.sql.ResultSet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRetriever {

    public DBRetriever(){}

    public List<Athlete> getAthletes() throws SQLException{

        Connection conn = null;

        try {
            conn = GetDBConnection.getInstance().getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
