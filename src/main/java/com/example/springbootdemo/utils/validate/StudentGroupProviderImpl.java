package com.example.springbootdemo.utils.validate;

import com.example.springbootdemo.vo.Student;

/**
 * @author liyongsheng
 * @date 2022/01/20 15:29
 **/
public class StudentGroupProviderImpl extends StudentGroupProvider<Student> {
    public static void main(String[] args) {
        System.out.println(new StudentGroupProviderImpl().getTClass());
    }
}
