/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.upload.service;

import org.disk.frame.config.DiskFrameConfig;
import org.disk.frame.exception.FrameException;
import org.disk.frame.upload.util.CheckFileUtils;
import org.disk.frame.upload.vo.UploadResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * 类描述
 * <p>详细描述</p>
 *
 * @author kyrie 2021/3/20 3:15 下午
 * @since jdk1.8
 */
@Service(value = "uploadService")
public class UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);

    private final DiskFrameConfig diskFrameConfig;
    /**
     * 构造注入
     */
    @Autowired
    public UploadService(DiskFrameConfig diskFrameConfig){
        this.diskFrameConfig = diskFrameConfig;
    }

    public UploadResult upload(MultipartFile file){

        var originalFilename = file.getOriginalFilename();
        //文件后缀
        var filePrefix = originalFilename.split("\\.")[1];
        //文件后缀验证
        this.validFilePrefix(filePrefix);

        String mimeType;
        try {
            mimeType = CheckFileUtils.mimeType(file.getInputStream());
        } catch (IOException e) {
            logger.error("获取输入流发生错误:{}",e.getMessage());
            throw new FrameException("获取输入流发生错误!");
        }
        //文件mime类型验证
        this.validAllowMiMe(filePrefix,mimeType);

        //仓库地址
        var repository = diskFrameConfig.getFileUploadPath();
        var newFolder = this.savePath();
        //创建仓库文件夹
        var savePath = repository.concat(newFolder);

        File destFolder = new File(savePath);
        if (!destFolder.exists()){
            var result = destFolder.mkdirs();
            if (result){
                logger.info("创建文件夹成功");
            }
        }
        //新的文件名
        var newFilename = this.newFileName().concat(".").concat(filePrefix);
        File newFile = new File(savePath.concat("/").concat(newFilename));

        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            logger.error("保存文件发生错误:{}",e.toString());
            throw new FrameException("保存文件发生错误");
        }

        var uploadResult = new UploadResult();
        uploadResult.setFolder(newFolder);
        uploadResult.setNewFileName(newFilename);
        uploadResult.setOriginalFilename(originalFilename);
        uploadResult.setSize(file.getSize());
        uploadResult.setSavePath(newFolder.concat("/").concat(newFilename));

        return uploadResult;
    }

    /**
     * @return 新文件名
     */
    private String newFileName(){
        return String.valueOf(System.currentTimeMillis());
    }

    /**
     * 文件夹路径
     * @return 文件夹路径
     */
    private String savePath(){
        return "/".concat(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMM")));
    }

    private void validFilePrefix(String prefix){
        Map<String, String> allowFilePrefixAndMiMe = diskFrameConfig.getAllowFilePrefixAndMiMe();
        if (!allowFilePrefixAndMiMe.containsKey(prefix)){
            logger.error("不支持的文件类型：{}",prefix);
            throw new FrameException("不支持的文件类型："+prefix);
        }
    }

    private void validAllowMiMe(String prefix,String mimeType){
        Map<String, String> allowFilePrefixAndMiMe = diskFrameConfig.getAllowFilePrefixAndMiMe();
        if (!allowFilePrefixAndMiMe.get(prefix).equals(mimeType)){
            logger.error("文件校验失败：原始文件类型[{}]和后缀对应的文件类型[{}]不一致",mimeType,allowFilePrefixAndMiMe.get(prefix));
            throw new FrameException("文件格式校验失败!");
        }
    }
}
