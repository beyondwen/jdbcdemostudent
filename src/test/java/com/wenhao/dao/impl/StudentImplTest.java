package com.wenhao.dao.impl;

import com.wenhao.dao.IStudentDAO;
import com.wenhao.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by lenovo on 2016/09/13.
 */
public class StudentImplTest {
    private IStudentDAO dao = new StudentImpl();


    @Test
    public void update() throws Exception {
        Student student = new Student();
        dao.update(student);
    }

    @Test
    public void get() throws Exception {
        Student student = dao.get("31");
        System.out.println(student);
    }

    @Test
    public void getAll() throws Exception {
        List<Student> list = dao.getAll();
        for (Student s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void delete() throws Exception {
        dao.delete("32");
    }

    @Test
    public void save() throws Exception {
        Student student = new Student();
        dao.save(student);
    }

}