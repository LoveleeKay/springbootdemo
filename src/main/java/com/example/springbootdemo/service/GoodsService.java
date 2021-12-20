package com.example.springbootdemo.service;

import com.example.springbootdemo.entity.Goods;
import com.example.springbootdemo.mapper.GoodsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author llys
 * @since 2021-11-02
 */
@Service
public class GoodsService extends ServiceImpl<GoodsMapper, Goods> {

}
