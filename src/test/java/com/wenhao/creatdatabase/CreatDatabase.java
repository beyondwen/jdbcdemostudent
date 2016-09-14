package com.wenhao.creatdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class CreatDatabase {

    public void creatDatabaseByJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://youip:3306/", "", "");
            Statement statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
