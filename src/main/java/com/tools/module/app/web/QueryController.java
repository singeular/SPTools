package com.tools.module.app.web;

import com.tools.common.dynamicquery.DynamicQuery;
import com.tools.common.model.Result;
import com.tools.common.util.HttpClient;
import com.tools.module.app.entity.AppTinyUrl;
import com.tools.module.app.service.AppQueryService;
import com.tools.module.app.service.AppTinyUrlService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在线查询
 */
@Api(tags ="在线查询")
@RestController
@RequestMapping("app/query")
public class QueryController {


    @Autowired
    private AppQueryService queryService;

    /**
     * 查询
     * @param sql
     * @return
     */
    @RequestMapping("crud")
    public Result crud(String sql) {
        return queryService.crud(sql);
    }
}
