/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

/**
 * 成功结果集类
 * <p>成功结果集类定义,成功情况下必须返回数据</p>
 *
 * @author kyrie 2020/11/22 12:52 下午
 * @since jdk1.8
 */
public class SuccessResult<T> extends AbstractResult<T>{
    /**
     * 成功时返回数据
     * @param data 数据
     */
    public SuccessResult(T data) {
        super(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getDesc(), data);
    }

    /**
     * 成功时返回数据和自定义成功信息
     * @param msg 消息
     * @param data 数据
     */
    public SuccessResult(String msg, T data){
        super(ResultCode.SUCCESS.getCode(), msg, data);
    }

    /**
     * 可以自定义成功码,成功消息,成功结果
     * @param code 码
     * @param msg 消息
     * @param data 数据
     */
    public SuccessResult(int code, String msg, T data) {
        super(code, msg, data);
    }
}
