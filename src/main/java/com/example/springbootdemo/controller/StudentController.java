package com.example.springbootdemo.controller;

import com.example.springbootdemo.exception.BusinessException;
import com.example.springbootdemo.utils.ResultUtil;
import com.example.springbootdemo.utils.validate.GroupA;
import com.example.springbootdemo.vo.DataResult;
import com.example.springbootdemo.vo.DemoResult;
import com.example.springbootdemo.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Slf4j
@Validated
public class StudentController {

    private Map<String, Student> studentMap = new HashMap<>();

    @GetMapping("/{id}")
    public DataResult getStudentById(@PathVariable @Max(100) String id) {
        log.info("id={}", id);
        return ResultUtil.genSuccessResult(studentMap.get(id));
    }


    @PostMapping
    public DemoResult addStudent(@RequestBody @Validated({GroupA.class}) Student student) {
        if (studentMap.containsKey(student.getId())) {
            throw new BusinessException("401", "Already exist this student");
        }
        log.info("student={}", student);
        studentMap.put(student.getId(), student);
        return ResultUtil.genSuccessResult();
    }

    @PutMapping
    public DemoResult modifyStudent(@RequestBody @Validated Student student) {
        log.info("student={}", student);
        if (!studentMap.containsKey(student.getId())) {
            throw new BusinessException("401", "Not exist this student");
        }
        studentMap.put(student.getId(), student);
        return ResultUtil.genSuccessResult();
    }

    @DeleteMapping
    public DemoResult deleteStudent(@RequestBody @Validated List<String> ids) {
        log.info("ids={}", ids);
        ids.forEach((id) -> studentMap.remove(id));
        return ResultUtil.genSuccessResult();
    }
}
