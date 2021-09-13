package com.example.springbootdemo.component.beanpost;

import com.example.springbootdemo.annotion.LogMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

//@Component
@Slf4j
public class LogMethodImpl implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        LogMethod[] declaredFields = bean.getClass().getAnnotationsByType(LogMethod.class);
        if (declaredFields.length > 0) {
            return new LogCglibProxy().CreatProxyedObj(bean.getClass());
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
