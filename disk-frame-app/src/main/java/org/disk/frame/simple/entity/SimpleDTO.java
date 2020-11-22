/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.simple.entity;

import javax.validation.constraints.NotNull;

/**
 * 类描述
 * <p>详细描述</p>
 *
 * @author kyrie 2020/11/22 3:11 下午
 * @since jdk1.8
 */
public class SimpleDTO {
    @NotNull(message = "不可以为空")
    private String name;
    @NotNull(message = "不可以为空")
    private String passWord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "SimpleDTO{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
