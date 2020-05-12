package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppEmail;

public interface AppEmailService {

    Result get(Long id);

    Result save(AppEmail email);

    Result delete(Long task);

    Result list(AppEmail email);
}
