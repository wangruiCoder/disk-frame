/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.exception;

/**
 * 工具类异常定义
 * <p>工具类异常定义</p>
 *
 * @author kyrie 2020/11/22 12:10 下午
 * @since jdk1.8
 */
public class UtilsException extends DiskFrameException{

    public UtilsException(String message) {
        super(message);
    }

    public UtilsException(String message, Throwable cause) {
        super(message, cause);
    }
}
