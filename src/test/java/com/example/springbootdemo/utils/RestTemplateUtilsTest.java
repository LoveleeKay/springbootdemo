package com.example.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
class RestTemplateUtilsTest {

    @Autowired
    private RestTemplateUtils restTemplateUtils;

    @Autowired
    @Qualifier("OCRTemplate")
    private RestTemplate restTemplate;

    @Test
    void postObject() {
        restTemplateUtils.postObject();
    }

    @Test
    void testTimeOut() {
        String url = "http://localhost:8888/iCommunity-web/topic/12345";
        HttpHeaders header = new HttpHeaders();
        // 需求需要传参为form-data格式
        header.setContentType(MediaType.TEXT_PLAIN);

        header.set("personId", "1234567abc");
        header.set("personCode", "1234567abc");
        header.set("personName", "1234567abc");
        header.set("communityUserId", "1234567abc");
        header.set("requestId", "1234567abc");
        header.set("reqSource", "1234567abc");
        header.set("appSource", "1234567abc");
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(header);
        long startTime = System.currentTimeMillis();
        try {
            ResponseEntity<JSONObject> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, JSONObject.class);
        } catch (RestClientException e) {
            System.out.println(123);
            e.printStackTrace();
        }

        System.out.println("spendTimes=" + (System.currentTimeMillis() - startTime) / 1000);
    }
}