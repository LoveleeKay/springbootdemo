package com.example.springbootdemo.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //configurableListableBeanFactory.getBeanDefinition("appcontext-service.xml");
        System.out.println("BeanLife::BeanFactoryPostProcessorTest::1.postProcessBeanFactory(BeanFactoryPostProcessor) 工厂后处理器, ApplicationContext容器初始化中refresh()中调用");
    }
}