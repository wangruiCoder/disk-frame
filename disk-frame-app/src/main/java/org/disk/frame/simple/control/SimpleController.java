/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.simple.control;

import org.disk.frame.exception.DiskFrameException;
import org.disk.frame.exception.FrameException;
import org.disk.frame.simple.entity.SimpleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}
