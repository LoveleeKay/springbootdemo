package com.example.springbootdemo.vo;

import com.example.springbootdemo.utils.validate.GroupA;
import com.example.springbootdemo.utils.validate.GroupB;
import com.example.springbootdemo.utils.validate.GroupC;
import com.example.springbootdemo.utils.validate.StudentGroupProviderImpl;
import lombok.Data;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Data
// @GroupSequence确定了里面包含的校验组的顺序，而且里面包含的都会校验，必须包含本类校验(Student.class)，
// 本类的校验其实就是Default.class，前提是外面的@validated必须包含Default.class
//@GroupSequence({GroupA.class, Student.class})
// GroupSequenceProvider 其实就是动态定制GroupSequence
@GroupSequenceProvider(value = StudentGroupProviderImpl.class)
public class Student extends BaseStudent {
    private String id;
    @Max(value = 1, groups = GroupA.class)
    @Min(value = 0, groups = GroupB.class)
    private int gender;
    @Min(value = 0)
    @Max(value = 10, groups = GroupC.class)
    private int age;
    private String name;
    @Valid
    private List<PointRecord> pointRecords;
}
