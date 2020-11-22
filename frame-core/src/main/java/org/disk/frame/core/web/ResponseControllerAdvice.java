/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.core.web;

import org.disk.frame.result.AbstractResult;
import org.disk.frame.result.SuccessResult;
import org.disk.frame.util.JsonUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 统一结果处理
 * <p>统一结果处理</p>
 *
 * @author kyrie 2020/11/22 4:29 下午
 * @since jdk1.8
 */
@RestControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        //如果是AbstractResult类型直接返回
        return !methodParameter.getParameterType().equals(AbstractResult.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果返回的String 直接转为json输出
        if (methodParameter.getGenericParameterType().equals(String.class)){
            return JsonUtils.toJson(new SuccessResult<>(data));
        }
        //根据实际情况日后扩展对File的支持

        return new SuccessResult<>(data);
    }
}
