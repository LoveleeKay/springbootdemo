package com.example.springbootdemo.vo;

import com.example.springbootdemo.utils.validate.GroupA;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class PointRecord {

    private int index;
    @Min(value = 0, groups = GroupA.class)
    @Max(100)
    private int point;
}
