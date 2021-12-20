package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 重试
 *
 * @author liyongsheng
 * @date 2021/12/20 09:20
 **/
@RequestMapping("/retry")
@RestController
public class RetryController {

    @Autowired
    private RetryService retryService;

    @PostMapping
    public void retry(){
        retryService.retryTest();
        System.out.println(123456);
    }
}
