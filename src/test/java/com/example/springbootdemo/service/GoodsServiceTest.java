package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class GoodsServiceTest {

    @Autowired
    private GoodsService goodsService;

    private final String[] names = {"aaaaaaaaaa", "bbbbbbbbbb", "cccccccccc", "dddddddddd", "eeeeeeeeee",
            "ffffffffff", "gggggggggg", "hhhhhhhhhh", "iiiiiiiiii", "jjjjjjjjjj"};

    @Test
    public void insertBatch(){
        long beginTime = System.currentTimeMillis();
        List<Goods> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6000000; i++) {
            Goods goods = new Goods();
            goods.setName(names[random.nextInt(10)]);
            goods.setPrice(random.nextInt(1000));
            goods.setDeleteFlag(0);
            list.add(goods);
        }
        goodsService.saveBatch(list);
        System.out.println("spend time=" + (System.currentTimeMillis() - beginTime));
    }

}