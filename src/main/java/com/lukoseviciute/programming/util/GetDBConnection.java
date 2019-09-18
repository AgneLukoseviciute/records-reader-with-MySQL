package com.lukoseviciute.programming.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class GetDBConnection {

    private static GetDBConnection instance = null;

    private GetDBConnection() {}

    public static GetDBConnection getInstance() {
        if (instance == null) {
            instance = new GetDBConnection();
        }

        return instance;
    }


    public Connection getConnection() throws IOException, SQLException {
        //reading config.properties
        GetConfigValues properties = new GetConfigValues();
        properties.getValues();

        String url = "jdbc:mysql://localhost:3306/athletes1?useTimezone=true&serverTimezone=UTC";
        String username = properties.getUserName();
        String password = properties.getPassword();
        Connection conn = DriverManager.getConnection(url, username, password);

        return conn;

    }


}
