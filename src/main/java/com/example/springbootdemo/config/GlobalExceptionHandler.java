package com.example.springbootdemo.config;

import com.example.springbootdemo.exception.BusinessException;
import com.example.springbootdemo.utils.ResultUtil;
import com.example.springbootdemo.vo.DemoResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public DemoResult exceptionHandler(BusinessException e){
        log.error("未知异常！原因是:"+e);
        return ResultUtil.genMessageResult(e.getErrMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DemoResult validHandler(Exception e){
        log.error("未知异常！原因是:"+e);
        return ResultUtil.genMessageResult(e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public DemoResult exceptionHandler(Exception e){
        log.error("未知异常！原因是:"+e);
        return ResultUtil.genMessageResult(e.getMessage());
    }
}
