package com.example.springbootdemo.dao;

import com.example.springbootdemo.security.po.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysPermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);

    List<SysPermission> selectByUserId(@Param("userId") Integer userId);
}