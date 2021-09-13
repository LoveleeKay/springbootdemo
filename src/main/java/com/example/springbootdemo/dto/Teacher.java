package com.example.springbootdemo.dto;

import lombok.Data;

@Data
public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private Long createDate;
}
