package com.example.springbootdemo.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("setApplicationContext begin");
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    //获取Bean
    public static <T> T getBean(Class<T> requiredType){
        return getApplicationContext().getBean(requiredType);
    }
    public static <T> T getBean(String name){
        return (T) getApplicationContext().getBean(name);
    }
}
