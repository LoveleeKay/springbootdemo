package com.example.springbootdemo.component.beanpost;

import com.example.springbootdemo.annotion.PostProcesser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;

//@Component
@Slf4j
public class PostProcesserImpl implements BeanPostProcessor {

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            PostProcesser annotation = declaredField.getAnnotation(PostProcesser.class);
            if (null == annotation) {
                continue;
            }
            declaredField.setAccessible(true);
            try {
                declaredField.set(bean, annotation.value());
                log.info("enter  self postProcessBeforeInitialization, value={}", annotation.value());
                log.info("bean is {}", bean.getClass().getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("enter self define postProcessAfterInitialization");
        return bean;
    }
}
