package com.example.springbootdemo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("all beans = {}", Arrays.toString(SpringContextUtil.getApplicationContext().getBeanDefinitionNames()));
    }
}
