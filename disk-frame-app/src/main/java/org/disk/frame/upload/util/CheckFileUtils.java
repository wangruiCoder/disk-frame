/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.upload.util;

import org.apache.tika.Tika;
import org.disk.frame.exception.FrameException;
import org.disk.frame.util.Args;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件检查工具类
 *
 * @author kyrie 2021/3/20 12:36 下午
 * @since jdk1.8
 */
public class CheckFileUtils {

    /**
     * 检查文件后缀是否包含在指定的数组中
     * @param filePrefix 文件后缀
     * @param prefix 后缀数组
     * @return true包含,false不包含
     */
    public static boolean checkFilePrefix(String filePrefix,String[] prefix){
        Args.notEmpty(filePrefix,"文件后缀");
        if (prefix.length != 0) {
            for (var s : prefix) {
                if (s.equals(filePrefix)) return true;
            }
        }
        return false;
    }

    /**
     * 获取文件的MediaType
     * @param inputStream 文件流
     * @return 文件MediaType值
     */
    public static String mimeType(InputStream inputStream){
        Tika tika = new Tika();
        var mimeType = "";
        try {
            mimeType = tika.detect(inputStream);
        } catch (IOException e) {
            throw new FrameException("解析文件MediaType发生错误:"+e.toString());
        }
        return mimeType;
    }



    public static void main(String[] args) {
        String[] a = {"jpg","png"};
        System.out.println(checkFilePrefix("jpg", a));
    }
}
