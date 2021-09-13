package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.TeacherDao;
import com.example.springbootdemo.dto.Teacher;
import com.example.springbootdemo.dto.TeacherInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;

    @GetMapping("/teacher")
    public Teacher getTeacherById(String id) {
        return teacherDao.getById(1, 22);
    }

    @GetMapping("/teacher-info")
    public TeacherInfoDto getTeacherInfoById(String id) {
        return teacherDao.getTeacherInfoById(1);
    }

    @PostMapping("/teacher")
    public int addTeacher(@RequestBody Teacher teacher){
        return teacherDao.insert(teacher);
    }

    @PutMapping("/teacher")
    public int modifyTeacher(@RequestBody Teacher teacher){
        return teacherDao.update(teacher);
    }

}
