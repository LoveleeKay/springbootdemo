package com.example.springbootdemo.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class RestTemplateUtils {

    @Autowired
    private RestTemplate restTemplate;

    public void postObject(){
        String url="http://172.17.6.23:8126/CTTQIOT/OCRService/API";
        Map<String, String> map = new HashMap<>();
        map.put("uuid","test");
        map.put("srcPDFFileUrl","http://contract-center-dev.oss-cn-shanghai.aliyuncs.com/contract/2019110815302714903320879f3ed015.pdf");
        map.put("cmpPDFFileUrl","http://contract-center-dev.oss-cn-shanghai.aliyuncs.com/contract/2019110815302714903320879f3ed015.pdf");
        HttpHeaders header = new HttpHeaders();
        // 需求需要传参为form-data格式
        header.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(map, header);
        JSONObject response = restTemplate.postForObject(url, httpEntity, JSONObject.class);
        System.out.println("response= " + response);
        System.out.println("value= " + response.getFloat("value"));
    }

}
