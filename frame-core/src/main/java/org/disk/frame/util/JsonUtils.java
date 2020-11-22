/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.disk.frame.exception.UtilsException;

import java.text.SimpleDateFormat;

/**
 * Json工具类
 * <p>Json工具类,方便处理Json</p>
 *
 * @author kyrie 2020/11/22 12:14 下午
 * @since jdk1.8
 */
public class JsonUtils {

    public static<T> String toJson(T t){
        String jsonStr;
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(sdf);

        try {
            jsonStr = objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new UtilsException("bean convert to json error: "+e.getMessage() ,e);
        }
        return jsonStr;
    }
}
