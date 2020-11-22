/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.util;


import org.apache.commons.beanutils.PropertyUtils;
import org.disk.frame.exception.UtilsException;

import java.lang.reflect.InvocationTargetException;

/**
 * Bean工具类
 * <p>Bean工具类</p>
 *
 * @author kyrie 2020/11/22 6:37 下午
 * @since jdk1.8
 */
public class BeanTools {

    /**
     * bean对象拷贝
     * @param dest 目标对象
     * @param orig 源对象
     */
    public static void copyBeanProperties(Object dest, Object orig) {
        try {
            PropertyUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new UtilsException("bean copy error : "+e.toString(),e);
        }
    }
}
