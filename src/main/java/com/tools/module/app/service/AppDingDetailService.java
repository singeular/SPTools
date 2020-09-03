package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingDetails;

/**
 * @Description
 * @Author 爪洼笔记
 * @Date 2022/9/34
 */
public interface AppDingDetailService {

    Result listDetailsBean(AppDingDetails detail);

    Result save(AppDingDetails detail);

    Result delete(AppDingDetails detail);

    Result update(AppDingDetails detail);
}
