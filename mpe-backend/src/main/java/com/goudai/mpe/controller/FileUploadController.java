package com.goudai.mpe.controller;

import com.goudai.mpe.util.AliOssUtils;
import com.goudai.mpe.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hegoudai@qq.com
 * @date 2020/4/19 16:59
 */
@RestController
@CrossOrigin("*")
public class FileUploadController {
    private static final Logger LOG = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private AliOssUtils ossUtils;

    @PostMapping("upload")
    public String upload(@RequestParam("image") MultipartFile image,
                         @RequestParam(value = "path", required = false) String path) {
        try {
            return ossUtils.upload(path,
                    FileUtils.getExtension(image.getOriginalFilename()), image.getInputStream());
        } catch (Exception e) {
            LOG.error("Failed to upload: {}", e);
            e.printStackTrace();
            return "failed";
        }
    }

}
