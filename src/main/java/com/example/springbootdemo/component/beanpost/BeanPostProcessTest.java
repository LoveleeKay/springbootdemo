package com.example.springbootdemo.component.beanpost;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanPostProcessTest implements BeanPostProcessor {

    @Value("${test.llys:0000}")
    private String llystest;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.contains("helloWorld")) {
            log.info("llystest={}", llystest);
            log.info("contextPath={}",contextPath);
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
