package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:external.properties"})
public class PropertiesImportConfig {
}
