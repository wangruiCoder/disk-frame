/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.util;

import java.util.Collection;
import java.util.Map;

/**
 * 参数验证工具类
 * <p>参数验证工具类</p>
 *
 * @author kyrie 2020/11/22 6:46 下午
 * @since jdk1.8
 */
public class Args {
    private Args() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T notNull(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " may not be null");
        } else {
            return argument;
        }
    }

    public static <T extends CharSequence> T notEmpty(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " may not be null");
        } else if (argument.length() == 0) {
            throw new IllegalArgumentException(name + " may not be empty");
        } else {
            return argument;
        }
    }

    public static <E, T extends Collection<E>> T notNull(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " may not be null");
        } else {
            return argument;
        }
    }

    public static <E, T extends Collection<E>> T notEmpty(T argument, String name) {
        if (argument == null) {
            throw new IllegalArgumentException(name + " may not be null");
        } else if (argument.isEmpty()) {
            throw new IllegalArgumentException(name + " may not be empty");
        } else {
            return argument;
        }
    }

    public static <K, V> Map<K, V> notEmpty(Map<K, V> argument, String name) {
        if (argument == null) {
            throw new NullPointerException(name + " may not be null");
        } else if (argument.isEmpty()) {
            throw new IllegalArgumentException(name + " may not be null");
        } else {
            return argument;
        }
    }
}
