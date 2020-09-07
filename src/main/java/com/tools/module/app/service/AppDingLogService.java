package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingSignInLog;

/**
 * @Description 蘑菇钉日志
 * @Author 爪洼笔记
 * @Date 2022/9/34
 */
public interface AppDingLogService {

    /**
     * 日志管理
     */
    Result listSignInLog(AppDingSignInLog log);

    Result delete(Integer logId);

    void save(AppDingSignInLog signInLog);

}
