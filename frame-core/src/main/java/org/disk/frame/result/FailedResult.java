/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

/**
 * 失败结果定义
 * <p>失败结果定义</p>
 *
 * @author kyrie 2020/11/22 12:58 下午
 * @since jdk1.8
 */
public class FailedResult<T> extends AbstractResult<T>{

    /**
     * 失败消息
     * @param msg 消息
     */
    public FailedResult(String msg){
        super(ResultCode.FAILED.getCode(), msg, null);
    }

    /**
     * 错误码,错误消息
     * @param code
     * @param msg
     */
    public FailedResult(int code, String msg) {
        super(code,msg,null);
    }

    /**
     * 失败消息和结果
     * @param msg 消息
     * @param data 结果
     */
    public FailedResult(String msg, T data) {
        super(ResultCode.FAILED.getCode(), msg, data);
    }

    /**
     * 失败码\消息\结果
     * @param code 码
     * @param msg 消息
     * @param data 结果
     */
    public FailedResult(int code, String msg, T data) {
        super(code, msg, data);
    }
}
