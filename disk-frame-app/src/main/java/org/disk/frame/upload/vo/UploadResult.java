/*
 * Copyright 2020 wangruiCoder owner
 */

package org.disk.frame.upload.vo;

/**
 * 文件上传结果
 *
 * @author kyrie 2021/3/20 4:09 下午
 * @since jdk1.8
 */
public class UploadResult {
    private String originalFilename;
    private String savePath;
    private String newFileName;
    private Long size;
    private String folder;

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public String toString() {
        return "UploadResult{" +
                "originalFilename='" + originalFilename + '\'' +
                ", savePath='" + savePath + '\'' +
                ", newFileName='" + newFileName + '\'' +
                ", size=" + size +
                ", folder='" + folder + '\'' +
                '}';
    }
}
