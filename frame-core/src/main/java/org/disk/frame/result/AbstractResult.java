/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 统一结果父类,所有结果的个性化都需要继承当前
 * <p>统一结果父类,所有结果的个性化都需要继承当前</p>
 *
 * @author kyrie 2020/11/22 12:30 下午
 * @since jdk1.8
 */
public class AbstractResult<T> implements Result<T>, Serializable {
    private static final long serialVersionUID = -4961152036474425782L;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    private int code;
    private String msg;

    public AbstractResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "AbstractResult{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
