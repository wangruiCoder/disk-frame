/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.core.web;

import org.disk.frame.result.AbstractResult;
import org.disk.frame.result.FailedResult;
import org.disk.frame.result.SuccessResult;
import org.disk.frame.util.JsonUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 统一结果处理
 * <p>统一结果处理</p>
 *
 * @author kyrie 2020/11/22 4:29 下午
 * @since jdk1.8
 */
@RestControllerAdvice
public class ResponseControllerAdvice extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        /*
         * 如果是AbstractResult类型 result=false 直接返回前端
         * 如果不是AbstractResult类型 result=true 需要走下面的beforeBodyWrite 判断是否为String 或者 ResponseEntity类型
         */
        boolean result ;
        try {
            result = methodParameter.getParameterType().getDeclaredConstructor().newInstance() instanceof AbstractResult;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return true;
        }

        return !result;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (methodParameter.getGenericParameterType().equals(String.class)){
            return JsonUtils.toJson(new SuccessResult<>(data));
        }

        System.out.println(methodParameter.getParameterType().toString());
        if (methodParameter.getParameterType().toString().equals("class org.springframework.http.ResponseEntity")){
            return data;
        }
        //根据实际情况日后扩展对File的支持

        return new SuccessResult<>(data);
    }

    /**
     * 重写异常处理，主要用来捕获spring boot框架级别的错误做个性化处理
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        return new ResponseEntity<>(new FailedResult<>(status.value(),ex.getMessage()), headers, status);
    }
}
