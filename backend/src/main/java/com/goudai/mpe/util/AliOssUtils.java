package com.goudai.mpe.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author hegoudai@qq.com
 * @date 2020/4/19 17:00
 */

public class AliOssUtils {

    public static String upload(String endpoint, String accessKeyId, String accessKeySecret,
                                 String bucket, String path, String fileType, InputStream inputStream){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String fileName = UUID.randomUUID().toString().replace("-", "");
        path = path == null ? "" : path + "/";
        String objectName = path + fileName + "." + fileType;
        ossClient.putObject(bucket, objectName, inputStream);
        ossClient.shutdown();

        String uri ="https://" + bucket + "." + endpoint.replace("http://", "") + "/" + objectName;
        return uri;
    }
}
