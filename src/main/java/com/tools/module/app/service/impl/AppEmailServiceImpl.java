package com.tools.module.app.service.impl;

import com.tools.common.dynamicquery.DynamicQuery;
import com.tools.common.model.PageBean;
import com.tools.common.model.Result;
import com.tools.common.util.DateUtils;
import com.tools.module.app.entity.AppEmail;
import com.tools.module.app.repository.AppEmailRepository;
import com.tools.module.app.service.AppEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppEmailServiceImpl implements AppEmailService {

    @Autowired
    private DynamicQuery dynamicQuery;
    @Autowired
    private AppEmailRepository emailRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result save(AppEmail email) {
        email.setGmtCreate(DateUtils.getTimestamp());
        emailRepository.saveAndFlush(email);
        return Result.ok("保存成功");
    }

    @Override
    public Result get(Long id) {
        AppEmail email = emailRepository.getOne(id);
        return Result.ok(email);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(Long id) {
        emailRepository.deleteById(id);
        return Result.ok("删除成功");
    }

    @Override
    public Result list(AppEmail email) {
        String nativeSql = "SELECT COUNT(*) FROM app_email";
        Long count = dynamicQuery.nativeQueryCount(nativeSql);
        PageBean<AppEmail> data = new PageBean<>();
        if(count>0){
            nativeSql = "SELECT * FROM app_email ORDER BY gmt_create desc";
            Pageable pageable = PageRequest.of(email.getPageNo(),email.getPageSize());
            List<AppEmail> list =  dynamicQuery.nativeQueryPagingList(AppEmail.class,pageable,nativeSql);
            data = new PageBean(list,count);
        }
        return Result.ok(data);
    }
}
