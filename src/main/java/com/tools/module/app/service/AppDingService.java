package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingDetails;
import com.tools.module.app.entity.AppDingUser;

/**
 * @Description 蘑菇钉
 * @Author 爪洼笔记
 * @Date 2022/9/34
 */
public interface AppDingService {
    /**
     * 登录获取token
     * @param user
     * @return
     */
    String login(AppDingUser user);

    /**
     * 获取计划学校ID
     * @param authorization
     * @return
     */
    String planId(String authorization);

    /**
     * 签到
     * @param authorization
     * @param planId
     * @param detail
     * @return
     */
    Result sin(String authorization, String planId, AppDingDetails detail);
}
