package com.example.springbootdemo.dao;

import com.example.springbootdemo.dto.Teacher;
import com.example.springbootdemo.dto.TeacherInfoDto;
import org.apache.ibatis.annotations.Param;

public interface TeacherDao {

    Teacher getById(@Param("id") int id, @Param("idd") int idd);

    TeacherInfoDto getTeacherInfoById(@Param("id") int id);

    int insert(@Param("teacher") Teacher teacher);

    int update(@Param("teacher") Teacher teacher);
}
