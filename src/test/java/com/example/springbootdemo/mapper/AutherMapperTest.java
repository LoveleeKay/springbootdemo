package com.example.springbootdemo.dao;

import com.example.springbootdemo.entity.Auther;
import com.example.springbootdemo.mapper.AutherMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AutherMapperTest {

    @Autowired
    private AutherMapper autherMapper;

    @Test
    public void testInsert(){
        System.out.println("testSelect start");
        Auther auther = new Auther();
        auther.setName("llys1");
        auther.setAge(11);
        autherMapper.insert(auther);
    }

    @Test
    public void testUpdate(){
        System.out.println("testUpdate start");
        Auther auther = new Auther();
        auther.setId(1);
        auther.setName("llys1");
        auther.setAge(12);
        autherMapper.updateById(auther);
    }

    @Test
    public void testDelete(){
        System.out.println("testDelete start");
        autherMapper.deleteById(1);
    }

    @Test
    public void testSelect() {

//        List<Goods> teacherList = autherMapper.selectList(null);
//        System.out.println("teachers = " + teacherList);
//        Goods id2Teacher = autherMapper.selectById(2);
//        System.out.println("id2Teacher=" + id2Teacher);
//        Page<Goods> pageDTO = autherMapper.selectPage(new Page<Goods>(1, 2), null);
//        System.out.println("pageDTO=" + pageDTO);
    }
}