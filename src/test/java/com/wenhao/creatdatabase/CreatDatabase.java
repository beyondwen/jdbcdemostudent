package com.wenhao.creatdatabase;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class CreatDatabase {

    @Test
    public void creatDatabaseByJdbc() throws Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://104.224.147.118:3306/student?createDatabaseIfNotExist=true&characterEncoding=UTF-8",
                            "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //connection.close();
        }
    }
}
