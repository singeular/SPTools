package com.tools.module.app.service.impl;

import com.tools.common.dynamicquery.DynamicQuery;
import com.tools.common.model.PageBean;
import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingDetails;
import com.tools.module.app.service.AppDingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 蘑菇钉
 * @Author 爪洼笔记
 * @Date 2022/9/34
 */
@Service
public class AppDingDetailServiceImpl implements AppDingDetailService {

    @Autowired
    private DynamicQuery dynamicQuery;

    @Override
    public Result listDetailsBean(AppDingDetails detail) {
        String countSql = "SELECT COUNT(*) FROM app_ding_details";
        Long totalCount = dynamicQuery.nativeQueryCount(countSql);
        PageBean<AppDingDetails> data = new PageBean<>();
        if (totalCount > 0) {
            StringBuffer nativeSql = new StringBuffer();
            nativeSql.append("SELECT * FROM app_ding_details ");
            Object[] params = new Object[]{};
            Pageable pageable = PageRequest.of(detail.getPageNo() - 1, detail.getPageSize());
            List<AppDingDetails> list = dynamicQuery.nativeQueryPagingList(AppDingDetails.class, pageable, nativeSql.toString(), params);
            data = new PageBean<>(list, totalCount);
        }
        return Result.ok(data);
    }

    @Override
    public Result save(AppDingDetails detail) {
        dynamicQuery.save(detail);
        return Result.ok();
    }

    @Override
    public Result delete(AppDingDetails detail) {
        String nativeSql = "DELETE FROM app_ding_details WHERE id=?";
        dynamicQuery.nativeExecuteUpdate(nativeSql,new Object[]{detail.getUserId()});
        return Result.ok();
    }

    @Override
    public Result update(AppDingDetails detail) {
        dynamicQuery.update(detail);
        return Result.ok();
    }
}
