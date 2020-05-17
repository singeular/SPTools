package com.tools.module.app.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "bai-du")
public class BaiDuProperties {

    private String appId;
    private String apiKey;
    private String accessKeySecret;

}
