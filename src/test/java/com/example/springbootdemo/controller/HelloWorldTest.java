package com.example.springbootdemo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldTest {

    @Autowired
    private HelloWorld helloWorld;

    @Test
    void helloWorld() {
        String hello = helloWorld.helloWorld();
        System.out.println(hello);
        Assertions.assertSame("hello world", hello);
    }
}