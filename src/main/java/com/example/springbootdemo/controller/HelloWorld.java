package com.example.springbootdemo.controller;

import com.example.springbootdemo.annotion.LogMethod;
import com.example.springbootdemo.annotion.PostProcesser;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@LogMethod
@RestController
@Slf4j
public class HelloWorld {

    @PostProcesser("123")
    private String test;

    @Value("${test.llys:0000}")
    private String llystest;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @GetMapping("/helloworld")
    @ApiOperation(value = "Hello World", notes = "Hello World")
    public String helloWorld() {
        log.info("llystest={}", llystest);
        log.info("contextPath={}",contextPath);
        return "hello world";
    }
}
