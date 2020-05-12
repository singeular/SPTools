package com.tools.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用Controller
 * 爪哇笔记 https://blog.52itstyle.vip
 */
@RestController
public class AbstractController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

}