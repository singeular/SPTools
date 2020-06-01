package com.tools.module.wechat.model;

import lombok.Data;

@Data
public class PushModel {

    private String page;

    private String templateId;

    private String openid;

    private String title;

    private String time;

    private String author;

}
