package com.example.springbootdemo.beanlife;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanLife::InitBeanPostProcessor::8.postProcessBeforeInitialization(BeanPostProcessor), bean = " + o.getClass());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanLife::InitBeanPostProcessor::12.postProcessAfterInitialization(BeanPostProcessor), bean = " + o.getClass());
        return o;
    }
}
