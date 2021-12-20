package com.example.springbootdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.dto.Teacher;
import com.example.springbootdemo.dto.TeacherInfoDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao extends BaseMapper<Teacher> {

    Teacher getById(@Param("id") int id, @Param("idd") int idd);

    List<Teacher> testIfTest(@Param("id") int id);

    TeacherInfoDto getTeacherInfoById(@Param("id") int id);

    @Override
    int insert(@Param("teacher") Teacher teacher);

    int update(@Param("teacher") Teacher teacher);
}
