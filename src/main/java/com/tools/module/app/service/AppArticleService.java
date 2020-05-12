package com.tools.module.app.service;

import com.tools.common.model.Result;
import com.tools.module.app.entity.AppArticle;

public interface AppArticleService {

    Result get(Long id);

    Result save(AppArticle article);

    Result delete(Long task);

    Result list(AppArticle article);
}
