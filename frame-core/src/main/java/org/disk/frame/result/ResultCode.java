/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

/**
 * 框架级统一错误码定义
 * <p>框架级统一错误码定义</p>
 *
 * @author kyrie 2020/11/22 12:42 下午
 * @since jdk1.8
 */
public enum ResultCode {
    SUCCESS(0,"操作成功"),
    ERROR(-9,"服务器内部发生错误,请联系管理员"),
    FAILED(-1,"一般性业务业务错误"),
    PARAM_ERROR(-2,"参数错误");

    private final int code;
    private final String desc;

    ResultCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
