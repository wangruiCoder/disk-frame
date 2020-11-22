/*
 * Copyright 2020 wangruiCoder owner
 */
package org.disk.frame.exception;

/**
 * DiskFrame 框架基础异常类
 * <p>DiskFrame 框架基础异常类,以后与框架有关的组件中的异常都继承当前类</p>
 *
 * @author kyrie 2020/11/22 12:03 下午
 * @since jdk1.8
 */
public abstract class DiskFrameException extends RuntimeException{

    private String message;
    private Throwable cause;

    public DiskFrameException() {
        super();
    }

    public DiskFrameException(String message) {
        super(message);
        this.message = message;
    }

    public DiskFrameException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public DiskFrameException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public DiskFrameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}
