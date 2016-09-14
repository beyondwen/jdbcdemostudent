package com.wenhao.dao.impl;

import com.wenhao.dao.IStudentDAO;
import com.wenhao.domain.Student;
import com.wenhao.utils.DatabaseConnection;
import com.wenhao.utils.JdbcUtils;
import com.wenhao.utils.ResourceClose;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class StudentImpl implements IStudentDAO {

    private Connection connection;
    private Statement statement;

    public void save(Student student) {

        connection = JdbcUtils.INSTANCE.getConnection();
        String sql = "insert into t_student (id,name,age) value(?,?,?) ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString((int) 1, "193");
            preparedStatement.setString((int) 2, "ddd");
            preparedStatement.setInt((int) 3, 22);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.INSTANCE.CloseResource(statement, connection);
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
        Student student = new Student();
        try {
            connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String sql = "select * from t_student where id = " + id + "";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
                student.setId(rs.getString("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceClose.CloseResource(statement, connection);
        }

        return student;
    }

    public List<Student> getAll() {

        List<Student> list = new ArrayList<Student>();
        connection = JdbcUtils.INSTANCE.getConnection();
        String sql = "select * from t_student";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getString("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
