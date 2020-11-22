/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.exception;

/**
 * 框架异常定义
 * <p>框架异常定义,主要用于解决框架层的异常捕获</p>
 *
 * @author kyrie 2020/11/22 4:15 下午
 * @since jdk1.8
 */
public class FrameException extends DiskFrameException{

    public FrameException(String message) {
        super(message);
    }

    public FrameException(String message, Throwable cause) {
        super(message, cause);
    }
}
