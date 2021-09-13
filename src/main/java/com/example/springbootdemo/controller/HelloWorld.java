package com.example.springbootdemo.controller;

import com.example.springbootdemo.annotion.LogMethod;
import com.example.springbootdemo.annotion.PostProcesser;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@LogMethod
@RestController
public class HelloWorld {

    @PostProcesser("123")
    private String test;

    @GetMapping("/helloworld")
    @ApiOperation(value = "Hello World", notes = "Hello World")
    public String helloWorld() {
        return "hello world";
    }
}
