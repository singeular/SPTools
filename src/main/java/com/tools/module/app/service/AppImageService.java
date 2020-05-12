package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppImage;

public interface AppImageService {

    void upload(AppImage image) ;

    Result list(AppImage image);
}

