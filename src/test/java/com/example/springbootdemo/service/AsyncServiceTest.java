package com.example.springbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    void getAsync() {
        log.info("start to process biz");
        Future<List<String>> res = asyncService.getAsync();
        try {
            log.info("res={}", res.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("start to end biz");
    }

    @Test
    void countDownLatchTest() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        log.info("start to process biz");
        List<String> res = new ArrayList<>();
        asyncService.getAsync(countDownLatch, res);
        try {
            countDownLatch.await();
            log.info("res={}", res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("start to end biz");
    }
}