package com.example.springbootdemo.filter;

import com.example.springbootdemo.inceptor.LogCostInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                        new LogCostInterceptor())
                // 需拦截的URI配置
                .addPathPatterns("/**")
                // 不需拦截的URI配置
                .excludePathPatterns("/swagger/**", "/static/**", "/resource/**");
    }
}
