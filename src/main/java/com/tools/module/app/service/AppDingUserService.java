package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingUser;

import java.util.List;

/**
 * @Description 蘑菇钉用户
 * @Author 爪洼笔记
 * @Date 2022/9/34
 */
public interface AppDingUserService {

    Result list(AppDingUser user);

    List<AppDingUser> listUser();

    AppDingUser get(Integer userId);

    Result save(AppDingUser user);

    Result delete(Integer userId);

    Result update(AppDingUser user);
}
