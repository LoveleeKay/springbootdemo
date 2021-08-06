package com.example.springbootdemo.utils;

import com.example.springbootdemo.vo.DataResult;
import com.example.springbootdemo.vo.DemoResult;

public class ResultUtil {
    private static final String CODE_SUCCESS = "200";
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static DemoResult genSuccessResult() {
        DemoResult demoResult = new DemoResult();
        demoResult.setCode(CODE_SUCCESS);
        demoResult.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return demoResult;
    }

    public static DemoResult genMessageResult(String message) {
        DemoResult demoResult = new DemoResult();
        demoResult.setMessage(message);
        return demoResult;
    }

    public static <T> DataResult<T> genSuccessResult(T data) {
        DataResult<T> DataResult = new DataResult<T>();
        DataResult.setCode(CODE_SUCCESS);
        DataResult.setMessage(DEFAULT_SUCCESS_MESSAGE);
        DataResult.setData(data);
        return DataResult;
    }

}
