package com.example.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 动物服务基类
 *
 * @author liyongsheng
 * @date 2022/01/10 14:45
 **/
@Service
public abstract class BaseAnimalService {

    @Autowired
    private TeacherService teacherService;

    public String getType(){
        System.out.println("teacher = " + teacherService.getTeacherById(2));
        return "annimal";
    }

    @Override
    public String toString() {
        return getType();
    }
}
