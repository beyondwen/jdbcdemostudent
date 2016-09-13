package com.wenhao.dao;

import com.wenhao.domain.Student;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public interface IStudentDAO {

    void save(Student student);

    void delete(String id);

    void update(Student student);

    Student get(String id);

    List<Student> getAll();

}
