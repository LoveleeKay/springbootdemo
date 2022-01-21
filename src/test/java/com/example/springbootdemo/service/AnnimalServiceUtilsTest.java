package com.example.springbootdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnnimalServiceUtilsTest {

//    @Autowired
//    private AnnimalServiceUtils annimalServiceUtils;

    @Test
    void test(){
        System.out.println(AnnimalServiceUtils.animalServiceMap.get("Cat").getType());
    }

}