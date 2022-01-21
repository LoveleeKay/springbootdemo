package com.example.springbootdemo.vo;

import com.example.springbootdemo.utils.validate.GroupB;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Student父类
 *
 * @author liyongsheng
 * @date 2022/01/19 16:30
 **/
@Data
public class BaseStudent {

    @Min(value = 1,groups = GroupB.class)
    private int fatherAge;

    private String fatherName;
}
