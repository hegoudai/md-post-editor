package com.goudai.mpe.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author hegoudai@qq.com
 * @date 2020/4/19 17:00
 */
@Configuration
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOssUtils {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucket;

    public String upload(String path, String fileType, InputStream inputStream) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String fileName = UUID.randomUUID().toString().replace("-", "");
        path = (path == null || path.length() == 0) ? "" : path + "/";
        String objectName = path + fileName + "." + fileType;
        ossClient.putObject(bucket, objectName, inputStream);
        ossClient.shutdown();

        String uri ="https://" + bucket + "." + endpoint.replace("http://", "") + "/" + objectName;
        return uri;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }


    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }


    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
