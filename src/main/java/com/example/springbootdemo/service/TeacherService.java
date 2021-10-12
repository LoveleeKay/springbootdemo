package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.TeacherDao;
import com.example.springbootdemo.dto.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacherById(int id) {
//        Teacher teacher = new Teacher();
//        teacher.setName("456");
//        return teacher;
        return teacherDao.getById(id,2);
    }
}
