package com.example.springbootdemo.dao;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.entity.Goods;
import com.example.springbootdemo.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GoodsMapperTest {

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void testInsert(){
        System.out.println("testSelect start");
        Goods goods4 = new Goods();
        goods4.setName("llys5");
        goods4.setPrice(105);
        goodsMapper.insert(goods4);
    }

    @Test
    public void testUpdate(){
        System.out.println("testUpdate start");
        Goods goods1 = new Goods();
        goods1.setId(1);
        goods1.setName("llys1");
        goods1.setPrice(101);
        Goods goods2 = new Goods();
        goods2.setId(2);
        goods2.setName("llys2");
        goods2.setPrice(102);
        Goods goods3 = new Goods();
        goods3.setId(3);
        goods3.setName("llys3");
        goods3.setPrice(103);
        goodsMapper.updateById(goods1);
        goodsMapper.updateById(goods2);
        goodsMapper.updateById(goods3);
    }

    @Test
    public void testDelete(){
        System.out.println("testDelete start");
        goodsMapper.deleteById(2);
    }

    @Test
    public void testSelect() {

        List<Goods> teacherList = goodsMapper.selectList(null);
        System.out.println("teachers = " + teacherList);
        Goods id2Teacher = goodsMapper.selectById(2);
        System.out.println("id2Teacher=" + id2Teacher);
        Page<Goods> page = new Page<>(1, 3);
        Page<Goods> result = goodsMapper.selectPage(page, Wrappers.<Goods>lambdaQuery().ge(Goods::getId, 1).orderByAsc(Goods::getUpdateDate));

        Page<Goods> pageDTO = goodsMapper.selectPage(new Page<Goods>(1, 2), null);
        System.out.println("pageDTO=" + pageDTO);
    }
}