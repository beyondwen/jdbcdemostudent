package com.wenhao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lenovo on 2016/09/13.
 */
public class DatabaseConnection {

    public static Connection getConnection() throws SQLException{
        //贾链欲执事
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//贾
            connection = DriverManager.getConnection("jdbc:mysql://yourip:3306/student", "root", "root");//链
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //connection.close();
        }
        return null;
    }
}
