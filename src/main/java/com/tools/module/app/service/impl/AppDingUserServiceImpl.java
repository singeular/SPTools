package com.tools.module.app.service.impl;

import com.tools.common.dynamicquery.DynamicQuery;
import com.tools.common.model.PageBean;
import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingUser;
import com.tools.module.app.service.AppDingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author 爪洼笔记
 * @Date 2022/9/34
 */
@Service
public class AppDingUserServiceImpl implements AppDingUserService {

    @Autowired
    private DynamicQuery dynamicQuery;

    @Override
    public Result listUserinfo(Integer pageNo, Integer pageSize) {
        String countSql = "SELECT COUNT(*) FROM app_ding_user";
        Long totalCount = dynamicQuery.nativeQueryCount(countSql);
        PageBean<AppDingUser> data = new PageBean<>();
        if (totalCount > 0) {
            StringBuffer nativeSql = new StringBuffer();
            nativeSql.append("SELECT * FROM app_ding_user");
            Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
            List<AppDingUser> list = dynamicQuery.nativeQueryPagingList(AppDingUser.class, pageable, nativeSql.toString());
            data = new PageBean<>(list, totalCount);
        }
        return Result.ok(data);
    }

    @Override
    public List<AppDingUser> listUser() {
        String nativeSql = "SELECT * FROM app_ding_user";
        Pageable pageable = PageRequest.of(0, 10);
        List<AppDingUser> list = dynamicQuery.nativeQueryPagingList(AppDingUser.class, pageable, nativeSql);
        return list;
    }

    @Override
    public Result save(AppDingUser user) {
        dynamicQuery.save(user);
        return Result.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(AppDingUser user) {
        String nativeSql = "DELETE FROM app_ding_user WHERE id=?";
        dynamicQuery.nativeExecuteUpdate(nativeSql,new Object[]{user.getUserId()});
        return Result.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(AppDingUser user) {
        dynamicQuery.update(user);
        return Result.ok();
    }
}
