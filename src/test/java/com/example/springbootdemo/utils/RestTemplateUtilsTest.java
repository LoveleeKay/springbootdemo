package com.example.springbootdemo.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestTemplateUtilsTest {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @Test
    void postObject() {
        restTemplateUtils.postObject();
    }
}