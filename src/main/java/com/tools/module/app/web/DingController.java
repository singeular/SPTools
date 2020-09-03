package com.tools.module.app.web;

import com.tools.common.config.AbstractController;
import com.tools.common.model.Result;
import com.tools.module.app.entity.AppDingDetails;
import com.tools.module.app.entity.AppDingUser;
import com.tools.module.app.service.AppDingService;
import com.tools.module.app.service.AppEmailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 爪哇笔记
 * @Date 2022/9/3
 */
@Api(tags ="蘑菇钉")
@RestController
@RequestMapping("/app/ding")
public class DingController extends AbstractController {


    @Autowired
    private AppDingService appDingService;

    /**
     * 列表
     */
    @RequestMapping("sign")
    public Result sign(){
        try {
            AppDingUser user = new AppDingUser();
            user.setUsername("******");
            user.setPassword("******");
            String authorization = appDingService.login(user);
            System.out.println(authorization);
            String planId = appDingService.planId(authorization);
            System.out.println(planId);
            AppDingDetails detailsBean = new AppDingDetails();
            detailsBean.setAddress("河南省.郑州市.人民政府");
            detailsBean.setCountry("中国");
            detailsBean.setProvince("河南省");
            detailsBean.setCity("郑州市");
            detailsBean.setLatitude("37.773296");
            detailsBean.setLongitude("113.759527");
            detailsBean.setDescription("开心");
            Result sin = appDingService.sin(authorization, planId, detailsBean);
            System.out.println(sin);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("-----------------------签到异常----------------------");
        }
        return Result.ok();
    }
}
