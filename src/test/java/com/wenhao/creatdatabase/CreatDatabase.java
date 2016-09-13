package com.wenhao.creatdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class CreatDatabase {

    public void creatDatabaseByJdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://104.224.147.118:3306/", "", "");
            Statement statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
