package com.example.springbootdemo.dao;

import com.example.springbootdemo.security.po.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByName(@Param("name") String name);
}