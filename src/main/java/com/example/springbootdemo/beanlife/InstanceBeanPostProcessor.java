package com.example.springbootdemo.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

public class InstanceBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {
        System.out.println("BeanLife::InstanceBeanPostProcessor::postProcessBeforeInstantiation2.实例化bean之前调用,即调用bean类构造函数之前调用 " + aClass.getName());
        /*try {
            return Class.forName(""+aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return null;//其实我不是很明白这里返回值得作用,之后可能会去深入理解
    }

    @Override
    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {
        System.out.println("BeanLife::InstanceBeanPostProcessor::postProcessAfterInstantiation4.返回boolean,bean实例化后调用,并且返回false则不会注入属性");
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        System.out.println("BeanLife::InstanceBeanPostProcessor::postProcessPropertyValues5.postProcessPropertyValues,在属性注入之前调用...... beanName = " + s + " 属性名集合 : " + Arrays.toString(propertyValues.getPropertyValues()));
        //System.out.println("BeanLife::InstanceBeanPostProcessor: :message = " + ((HelloWorld)o).getMessage()); 这里可以看到message还是null
        return propertyValues;//这里要返回propertyValues,否则属性无法注入
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanLife::InstanceBeanPostProcessor: :9.postProcessBeforeInitialization(InstantiationAwareBeanPostProcessor) ");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("BeanLife::InstanceBeanPostProcessor: :13.postProcessAfterInitialization(InstantiationAwareBeanPostProcessor) ");
        return o;
    }
}
