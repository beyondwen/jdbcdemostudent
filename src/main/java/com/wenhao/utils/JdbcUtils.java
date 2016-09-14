package com.wenhao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by lenovo on 2016/09/14.
 */
public enum JdbcUtils {
    INSTANCE;

    private static Properties properties = new Properties();

    static {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
            Class.forName(properties.getProperty("jdbcdriverName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(properties.getProperty("jdbcurl"), properties.getProperty("jdbcname"), properties.getProperty("jdbcpassword"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void CloseResource(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
