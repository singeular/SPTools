package com.tools.common.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 通用访问拦截匹配
 * 爪哇笔记 https://blog.52itstyle.vip
 */
@Controller
public class IndexController {


    @GetMapping("{url}.html")
    public String page(@PathVariable("url") String url) {
        return url;
    }

    @GetMapping("{module}/{url}.html")
    public String page(@PathVariable("module") String module,@PathVariable("url") String url) {
        return module + "/" + url;
    }
    @GetMapping("{module}/{sub}/{url}.html")
    public String page(@PathVariable("module") String module,
                       @PathVariable("url") String url,
                       @PathVariable("sub") String sub) {
        return module + "/" + sub + "/" + url;
    }
    @GetMapping("{module}/{sub}/{smallSub}/{url}.html")
    public String page(@PathVariable("module") String module,
                       @PathVariable("url") String url,
                       @PathVariable("sub") String sub,
                       @PathVariable("smallSub") String smallSub) {
        return module + "/" + sub + "/" + smallSub + "/" + url;
    }

}