/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.core.web;

import org.disk.frame.exception.DiskFrameException;
import org.disk.frame.result.AbstractResult;
import org.disk.frame.result.FailedResult;
import org.disk.frame.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * 统一异常处理器
 * <p>统一异常处理器,框架层面发生异常后对异常结果进行捕获转换</p>
 *
 * @author kyrie 2020/11/22 3:38 下午
 * @since jdk1.8
 */
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    private Environment environment;

    /**
     * 表单入参异常捕获
     * @param e 参数异常
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AbstractResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        //获取属性名称
        FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        //获取错误提示语
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);

        //错误提示信息进行返回
        return new FailedResult<>(ResultCode.PARAM_ERROR.getCode(),fieldError.getField()+" "+objectError.getDefaultMessage());
    }

    /**
     * 框架运行异常处理
     * @param e 运行时异常
     * @return 错误信息
     */
    @ExceptionHandler(DiskFrameException.class)
    public AbstractResult DiskFrameExceptionHandler(DiskFrameException e){
        return new FailedResult<>(ResultCode.ERROR.getCode(), e.getMessage());
    }

    /**
     * 框架运行异常处理
     * @param e 运行时异常
     * @return 错误信息
     */
    @ExceptionHandler(RuntimeException.class)
    public AbstractResult RuntimeExceptionHandler(RuntimeException e){
        //文件上传超大异常捕获
        if (e instanceof MaxUploadSizeExceededException){
            return new FailedResult<>(ResultCode.ERROR.getCode(),"上传文件超过单个文件["+environment.getProperty("spring.servlet.multipart.max-file-size")+"]最大限制");
        }

        return new FailedResult<>(ResultCode.ERROR.getCode(), ResultCode.ERROR.getDesc());
    }

}
