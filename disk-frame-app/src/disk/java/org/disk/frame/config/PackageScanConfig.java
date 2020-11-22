/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 包扫描定义
 * <p>包扫描定义类,开发人员可以根据情况在此处增加扫描包</p>
 *
 * @author kyrie 2020/11/22 3:56 下午
 * @since jdk1.8
 */
@Configuration
@ComponentScan({"org.disk.frame.core"})
public class PackageScanConfig {
}
