package com.example.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 动物服务工具类
 *
 * @author liyongsheng
 * @date 2022/01/10 14:49
 **/
@Service
public class AnnimalServiceUtils {

    @Autowired
    private CatService catService;

    @Autowired
    private DogService dogService;

    public static final Map<String, BaseAnimalService> animalServiceMap = new HashMap<>();

    @PostConstruct
    public void init() {
        animalServiceMap.put("Cat", catService);
        animalServiceMap.put("Dog", dogService);
    }
}
