/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

/**
 * 类描述
 * <p>详细描述</p>
 *
 * @author kyrie 2021/2/6 10:30 下午
 * @since jdk1.8
 */
public class CustomResult<T> extends AbstractResult{
    private static final long serialVersionUID = -3901011981875668488L;

    private int returnCode;

    private String message;

    public CustomResult() {
    }

    public CustomResult(int returnCode, String message) {
        this.returnCode = returnCode;
        this.message = message;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomResult{" +
                "returnCode=" + returnCode +
                ", message='" + message + '\'' +
                '}';
    }
}
