package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.Teacher;
import com.example.springbootdemo.service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class TeacherControllerTest {

    @Autowired
    private TeacherController teacherController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    @BeforeEach
    void setUp() {
        Teacher teacher = new Teacher();
        teacher.setName("llys");
        teacher.setAge(99);
        Mockito.when(teacherService.getTeacherById(Mockito.anyInt()))
                .thenReturn(teacher);
    }

    @Test
    void getTeacherById() {
//        System.out.println(teacherController.getTeacherById(2));
    }

    @Test
    void getTeacherInfoById() {
    }

    @Test
    void addTeacher() {
    }

    @Test
    void modifyTeacher() {
    }
}