package com.wenhao.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by lenovo on 2016/09/13.
 */
public class DatabaseConnection {

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

    public static Connection getConnection() throws SQLException {
        //贾链欲执事
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(properties.getProperty("jdbcurl"), properties.getProperty("jdbcname"), properties.getProperty("jdbcpassword"));//链
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
