package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
//重试注解
@EnableRetry
public class SpringbootdemoApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(SpringbootdemoApplication.class, args);

        // 以下内容为打印访问地址，如不需要可以不加
        log.info("..######..##.....##..######...######..########..######...######.\n" +
                ".##....##.##.....##.##....##.##....##.##.......##....##.##....##\n" +
                ".##.......##.....##.##.......##.......##.......##.......##......\n" +
                "..######..##.....##.##.......##.......######....######...######.\n" +
                ".......##.##.....##.##.......##.......##.............##.......##\n" +
                ".##....##.##.....##.##....##.##....##.##.......##....##.##....##\n" +
                "..######...#######...######...######..########..######...######.");
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        if (!StringUtils.hasLength(path)) {
            path = "";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application  is running! Access URLs:\n\t" +
                "Local访问网址: \t\thttp://localhost:" + port + path + "\n\t" +
                "External访问网址: \thttp://" + ip + ":" + port + path + "\n\t" +
                "----------------------------------------------------------");

        log.info("123456 password = {}", new BCryptPasswordEncoder().encode("123456"));
    }

}
