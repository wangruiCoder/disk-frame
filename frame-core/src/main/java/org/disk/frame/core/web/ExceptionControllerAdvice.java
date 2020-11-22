/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.core.web;

import org.disk.frame.exception.DiskFrameException;
import org.disk.frame.result.AbstractResult;
import org.disk.frame.result.FailedResult;
import org.disk.frame.result.ResultCode;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 类描述
 * <p>详细描述</p>
 *
 * @author kyrie 2020/11/22 3:38 下午
 * @since jdk1.8
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * 参数异常捕获
     * @param e 参数异常
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AbstractResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        //获取属性名称
        FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        //获取错误提示语
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);

        FailedResult failedResult = new FailedResult(ResultCode.PARAM_ERROR.getCode(),fieldError.getField()+" "+objectError.getDefaultMessage());
        //错误提示信息进行返回
        return failedResult;
    }

    /**
     * 框架运行异常处理
     * @param e 运行时异常
     * @return 错误信息
     */
    @ExceptionHandler(DiskFrameException.class)
    public AbstractResult DiskFrameExceptionHandler(DiskFrameException e){
        FailedResult failedResult = new FailedResult(ResultCode.ERROR.getCode(), e.getMessage());
        return failedResult;
    }

    /**
     * 框架运行异常处理
     * @param e 运行时异常
     * @return 错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    public AbstractResult RuntimeExceptionHandler(RuntimeException e){
        System.out.println(e.toString());
        FailedResult failedResult = new FailedResult(ResultCode.ERROR.getCode(), ResultCode.ERROR.getDesc());
        return failedResult;
    }

}
