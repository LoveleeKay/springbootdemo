package com.example.springbootdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private String errCode;
    private String errMessage;
}
