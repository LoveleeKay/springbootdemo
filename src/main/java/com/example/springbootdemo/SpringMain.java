package com.example.springbootdemo;

import com.example.springbootdemo.beanlife.BeanLifeTestBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:application-context.xml");
        BeanLifeTestBean obj = (BeanLifeTestBean)context.getBean("beanLifeTestBean");
        System.out.println("14.Bean working, message = " + obj.getMessage());
        //((ClassPathXmlApplicationContext)context).refresh();
        ((ClassPathXmlApplicationContext)context).close();
    }
}
