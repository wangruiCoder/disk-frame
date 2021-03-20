/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * disk frame 框架自定义配置类
 * <p>disk frame 框架自定义配置类,如果配置不够可以自定在当前配置类中自己增加</p>
 *
 * @author kyrie 2021/3/20 12:13 下午
 * @since jdk1.8
 */
@Component
@ConfigurationProperties(prefix = "disk.frame")
public class DiskFrameConfig {
    private String fileUploadPath;
    private Map<String,String> allowFilePrefixAndMiMe;

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Map<String, String> getAllowFilePrefixAndMiMe() {
        return allowFilePrefixAndMiMe;
    }

    public void setAllowFilePrefixAndMiMe(Map<String, String> allowFilePrefixAndMiMe) {
        this.allowFilePrefixAndMiMe = allowFilePrefixAndMiMe;
    }
}
