package com.example.springbootdemo.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.dto.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherDaoTest {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void testSelect() {
        System.out.println("testSelect start");
        List<Teacher> teacherList = teacherDao.selectList(null);
        System.out.println("teachers = " + teacherList);
        Teacher id2Teacher = teacherDao.selectById(2);
        System.out.println("id2Teacher=" + id2Teacher);
        Page<Teacher> pageDTO = teacherDao.selectPage(new Page<Teacher>(1, 2), null);
        System.out.println("pageDTO=" + pageDTO);
    }

}