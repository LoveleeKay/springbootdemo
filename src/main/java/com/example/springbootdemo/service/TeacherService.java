package com.example.springbootdemo.service;

import com.example.springbootdemo.dao.TeacherDao;
import com.example.springbootdemo.dto.Teacher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class TeacherService {

    private final TeacherDao teacherDao;

    public Teacher getTeacherById(int id) {
//        Teacher teacher = new Teacher();
//        teacher.setName("456");
//        return teacher;
        return teacherDao.getById(id,2);
    }




}
