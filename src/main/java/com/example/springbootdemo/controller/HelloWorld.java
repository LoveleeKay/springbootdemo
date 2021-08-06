package com.example.springbootdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/helloworld")
    @ApiOperation(value = "Hello World", notes = "Hello World")
    public String helloWorld() {
        return "hello world";
    }
}
