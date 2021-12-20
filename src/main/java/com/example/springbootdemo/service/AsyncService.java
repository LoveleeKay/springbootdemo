package com.example.springbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 异步和多线程
 *
 * @author liyongsheng
 * @date 2021/12/17 15:35
 **/
@Slf4j
@Service
public class AsyncService {

    /**
     * 本类调用无效，因为没有走代理类，需要其他类调用
     * @return
     */
    @Async
    public Future<List<String>> getAsync(){
        log.info("start to query by id Async");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("end to query by id Async");
        return new AsyncResult<>(Stream.of("1", "2").collect(Collectors.toList()));
    }

    @Async
    public void getAsync(CountDownLatch countDownLatch, List<String> res){
        log.info("start to query by id Async");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("end to query by id Async");
        res.addAll(Stream.of("1", "2").collect(Collectors.toList()));
        countDownLatch.countDown();
    }
}
