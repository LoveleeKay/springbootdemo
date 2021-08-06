package com.example.springbootdemo.vo;

import com.example.springbootdemo.utils.validate.GroupA;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.groups.Default;
import java.util.List;

@Data
public class Student {
    private String id;
    @Max(value = 1, groups = GroupA.class)
    @Min(value = 0, groups = Default.class)
    private int gender;
    private int age;
    private String name;
    @Valid
    private List<PointRecord> pointRecords;
}
