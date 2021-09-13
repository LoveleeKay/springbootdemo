package com.example.springbootdemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeacherInfoDto {
    private Integer teacherId;
    private String name;
    private Integer age;
    private Long createDate;
    List<Student> studentList;
}
