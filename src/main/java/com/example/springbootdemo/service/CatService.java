package com.example.springbootdemo.service;

import org.springframework.stereotype.Service;

/**
 * @author liyongsheng
 * @date 2022/01/10 14:47
 **/
@Service
public class CatService extends BaseAnimalService {

    public CatService(){
        System.out.println("CatService created");
    }

    @Override
    public String getType() {
        System.out.println("BaseAnimalService getType =  " + super.getType());
        return "Cat";
    }
}
