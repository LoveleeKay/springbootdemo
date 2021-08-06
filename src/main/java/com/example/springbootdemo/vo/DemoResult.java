package com.example.springbootdemo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DemoResult {
    private String code;
    private String message;

    private DemoResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static DemoResult generateSuccessResult() {
        return new DemoResult("200", "success");
    }
}
