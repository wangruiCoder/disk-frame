/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.result;

/**
 * 统一结果模板,规定框架中结果基础格式
 * <p>统一解决模板,规定框架中结果基础格式</p>
 *
 * @author kyrie 2020/11/22 12:28 下午
 * @since jdk1.8
 */
public interface Result<T> {
    T getData();
    String getMsg();
    int getCode();
}
