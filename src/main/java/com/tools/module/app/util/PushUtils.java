package com.tools.module.app.util;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppNotice;
import org.json.JSONObject;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 消息推送
 */
@Component
@Configuration
@EnableConfigurationProperties({PushProperties.class})
public class PushUtils {

    private PushProperties push;

    public PushUtils(PushProperties push) {
        this.push = push;
    }

    public String send(AppNotice notice){
        RestTemplate client = new RestTemplate();
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("content", notice.getContent());
        paramMap.add("channel", notice.getChannel()==null?"SPTools":notice.getChannel());
        paramMap.add("appkey", push.getCommonKey());
        return client.postForObject(push.getUrl(), paramMap , String.class);
    }
}
