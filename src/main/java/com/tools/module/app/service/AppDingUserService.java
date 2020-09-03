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

    Result listUserinfo(Integer pageNo, Integer pageSize);

    List<AppDingUser> listUser();

    Result save(AppDingUser user);

    Result delete(AppDingUser user);

    Result update(AppDingUser user);
}
