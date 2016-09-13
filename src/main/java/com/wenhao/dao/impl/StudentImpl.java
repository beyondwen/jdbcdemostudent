package com.wenhao.dao.impl;

import com.wenhao.dao.IStudentDAO;
import com.wenhao.domain.Student;
import com.wenhao.utils.DatabaseConnection;
import com.wenhao.utils.ResourceClose;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class StudentImpl implements IStudentDAO {

    private Connection connection;
    private Statement statement;

    public void save(Student student) {
        try {
            connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into t_student (id,name,age) value('31','wenhao',10) ";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void delete(String id) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String sql = "delete from t_student where id = '32'";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void update(Student student) {
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String sql = "update t_student set name='lisi',age=20 where id = '31'";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceClose.CloseResource(statement, connection);
        }

    }

    public Student get(String id) {
        return null;
    }

    public List<Student> getAll() {
        return null;
    }
}
