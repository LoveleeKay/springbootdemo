package com.example.springbootdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RetryServiceTest {

    @Autowired
    private RetryService retryService;

    @Test
    void retryTest() {
        retryService.retryTest();
        System.out.println(123456);
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread in out put");
        }
    }
}