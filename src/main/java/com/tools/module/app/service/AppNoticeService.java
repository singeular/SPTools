package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppNotice;

public interface AppNoticeService {

    Result get(Long id);

    Result save(AppNotice notice);

    Result delete(Long task);

    Result list(AppNotice notice);
}
