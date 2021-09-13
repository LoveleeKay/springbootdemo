package com.example.springbootdemo.dto;

import lombok.Data;

@Data
public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private String desc;
    private String teacher;
    private Long createDate;
}
