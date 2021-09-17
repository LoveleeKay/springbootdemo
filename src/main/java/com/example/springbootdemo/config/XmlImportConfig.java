package com.example.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:application-context.xml", "classpath:transaction.xml"})
public class XmlImportConfig {
}
