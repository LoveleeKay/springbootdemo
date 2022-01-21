package com.example.springbootdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author liyongsheng
 * @date 2022/01/10 14:49
 **/
@Service
public class DogService extends BaseAnimalService {

    @Override
    public String getType() {
        return "Dog";
    }
}
