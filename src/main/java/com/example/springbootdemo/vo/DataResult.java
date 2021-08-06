package com.example.springbootdemo.vo;

import lombok.Data;

@Data
public class DataResult<T> extends DemoResult {
    private T data;
}
