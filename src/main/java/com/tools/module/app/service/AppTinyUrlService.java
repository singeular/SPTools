package com.tools.module.app.service;

import cn.hutool.db.Page;
import com.tools.common.model.Result;
import com.tools.module.app.entity.AppTinyUrl;

public interface AppTinyUrlService {

    Result save(AppTinyUrl tinyUrl);

    String getUrl(String tinyKey);

    Result list(Page page);
}

