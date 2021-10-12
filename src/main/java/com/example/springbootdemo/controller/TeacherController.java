package com.example.springbootdemo.controller;

import com.example.springbootdemo.dao.TeacherDao;
import com.example.springbootdemo.dto.Teacher;
import com.example.springbootdemo.dto.TeacherInfoDto;
import com.example.springbootdemo.exception.BusinessException;
import com.example.springbootdemo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher")
    public Teacher getTeacherById(int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("hello","123123123");
        return teacherService.getTeacherById(id);
    }

    @GetMapping("/teacher/testiftest")
    public List<Teacher> testIfTest(int id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String helloValue = (String) session.getAttribute("hello");
        System.out.println(helloValue);
        return teacherDao.testIfTest(id);
    }

    @GetMapping("/teacher-info")
    public TeacherInfoDto getTeacherInfoById(String id) {
        return teacherDao.getTeacherInfoById(1);
    }

    @PostMapping("/teacher")
//    @Transactional
    public int addTeacher(@RequestBody Teacher teacher){
        teacherDao.insert(teacher);
        System.out.println(111);
        throw new BusinessException("100", "error");
//        return teacherDao.insert(teacher);
    }

    @PutMapping("/teacher")
    public int modifyTeacher(@RequestBody Teacher teacher){
        return teacherDao.update(teacher);
    }

}
