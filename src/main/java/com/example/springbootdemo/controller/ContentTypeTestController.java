package com.example.springbootdemo.controller;

import com.example.springbootdemo.vo.Student;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/content-type/test")
public class ContentTypeTestController {

    @RequestMapping(method = RequestMethod.POST, value = "/postStu", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public Student postStu(Student student) {
        System.out.println(student);
        Student student1 = new Student();
        student1.setName("llysss");
        return student;
    }

}
