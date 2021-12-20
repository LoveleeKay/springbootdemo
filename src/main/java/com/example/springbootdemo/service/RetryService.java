package com.example.springbootdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 重试服务
 *
 * @author liyongsheng
 * @date 2021/12/17 15:25
 **/
@Slf4j
@Service
public class RetryService {

    /**
     *  重试机制，3包括第一次，delay 表示每次间隔时间，比如delay=2,multiply=3，则第二次执行等待2s,第三次执行等待2*3s,第4次执行等待2*3*3s,
     * @author liyongsheng
     * @date 2021/12/17 15:26
     * @since 1.0.0
     * @return void
     */
    @Async
    @Retryable(recover = "recover2", value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 2000L, multiplier = 2))
    public void retryTest() {
        log.info("start to retryTest,{}", "abc");
        throw new RuntimeException("123");
    }

    @Recover
    public void recover1(Exception e) {
        log.info("start to recover1");
        log.error("e={}", e);
    }

    @Recover
    public void recover2(Exception e) {
        log.info("start to recover2");
        log.error("e={}, {}", e.toString(), e.getMessage());
    }
}
