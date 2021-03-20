/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.simple.control;

import org.disk.frame.exception.FrameException;
import org.disk.frame.result.CustomResult;
import org.disk.frame.result.FailedResult;
import org.disk.frame.result.GeneralResult;
import org.disk.frame.simple.entity.SimpleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 类描述
 * <p>详细描述</p>
 *
 * @author kyrie 2020/11/22 3:10 下午
 * @since jdk1.8
 */
@Controller
public class SimpleController {

    @RequestMapping("/test")
    @ResponseBody
    public String testValid(@RequestBody @Valid SimpleDTO simple){
        System.out.println(simple.toString());
        if (simple.getName().equals("wangrui")){
            throw new FrameException("测试异常");
        }

        return simple.toString();
    }

    @RequestMapping("/testobject")
    @ResponseBody
    public SimpleDTO testReturnObject(@RequestBody @Valid SimpleDTO simple){
        return simple;
    }

    @RequestMapping("/testobject1/{abc}")
    @ResponseBody
    public SimpleDTO testReturnObject1(@PathVariable(value = "ab",required = true) String abc, @RequestBody @Valid SimpleDTO simple){
        return simple;
    }

    @RequestMapping("/testobject2")
    @ResponseBody
    public CustomResult<Object> testCusResult(){
        return new CustomResult<>(2333,"自定义结果集");
    }

    @RequestMapping("/testobject3")
    @ResponseBody
    public GeneralResult<Object> testCusResult2(){
        return new FailedResult<>(2333,"自定义结果集");
    }
}
