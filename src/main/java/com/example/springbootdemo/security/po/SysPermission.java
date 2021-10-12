package com.example.springbootdemo.security.po;

import java.io.Serializable;
import lombok.Data;

/**
 * sys_permission
 * @author 
 */
@Data
public class SysPermission implements Serializable {
    private Integer id;

    private String name;

    private String descritpion;

    private String url;

    private Integer pid;

    private static final long serialVersionUID = 1L;
}