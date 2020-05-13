package com.tools.module.app.web;

import com.tools.common.model.Result;
import com.tools.common.util.HttpClient;
import com.tools.module.app.entity.AppTinyUrl;
import com.tools.module.app.service.AppTinyUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短连接
 */
@RestController
@RequestMapping("app/tinyUrl")
public class TinyUrlController {

    @Autowired
    private AppTinyUrlService tinyUrlService;

    /**
     * 生成
     * @param tinyUrl
     * @return
     */
    @RequestMapping("save")
    public Result save(AppTinyUrl tinyUrl) {
        int code = HttpClient.client(tinyUrl.getUrl());
        if(code==200){
            return tinyUrlService.save(tinyUrl);
        }else{
            return Result.error("是不是网址心里没点数吗？瞎JB输！");
        }
    }
}
