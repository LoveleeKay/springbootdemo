package com.example.springbootdemo.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Teacher {
    private Integer id;
    private String name;
    private Integer age;
    private Date createDate;
}
