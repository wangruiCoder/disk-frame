/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.upload.control;

import org.disk.frame.upload.service.UploadService;
import org.disk.frame.upload.vo.UploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 类描述
 * <p>详细描述</p>
 *
 * @author kyrie 2021/3/20 11:25 上午
 * @since jdk1.8
 */
@RestController
public class UploadController {

    private final UploadService uploadService;

    @Autowired
    public UploadController(UploadService uploadService){
        this.uploadService = uploadService;
    }

    @RequestMapping(value = "/upload")
    public UploadResult upload(@RequestParam("file") MultipartFile file){
        return uploadService.upload(file);
    }
}
