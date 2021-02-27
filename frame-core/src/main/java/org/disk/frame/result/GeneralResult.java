/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * 普通的返回结果类模版
 * <p>常用属性code,msg,data.如果这些属性不够用可以继承当前类在子类中继续扩展</p>
 *
 * @author kyrie 2021/2/6 8:28 下午
 * @since jdk1.8
 */
public class GeneralResult<T> extends AbstractResult{

    private static final long serialVersionUID = -9013450006845294205L;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    private int code;
    private String msg;

    public GeneralResult() {
    }

    public GeneralResult(int code, String msg, T data){
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

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

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
