package com.tools.module.app.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;

/**
 * 阿里云存储
 */
@Component
@Configuration
@EnableConfigurationProperties({AliYunProperties.class})
public class AliYunUtils {

    private AliYunProperties aliYun;

    public AliYunUtils(AliYunProperties aliYun) {
        this.aliYun = aliYun;
    }

    private OSS instance;

    @PostConstruct
    public void init() {
        try {
            instance = new OSSClientBuilder().
                    build(aliYun.getEndpoint(), aliYun.getAccessKeyId(), aliYun.getAccessKeySecret());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传
     */
    public void upload(File file, String fileName){
        instance.putObject(aliYun.getBucketName(),fileName,file);
    }
    /**
     * 上传
     */
    public void upload(InputStream file, String fileName){
        instance.putObject(aliYun.getBucketName(),fileName,file);
    }
}
