package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.TeacherDao;
import com.example.springbootdemo.dto.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherDao teacherDao;

    @Test
    void getTeacherById() {
        Teacher teacher = teacherDao.getById(2,2);
        System.out.println(teacher.getName());
        Assertions.assertSame("123", teacher.getName());
    }
}