package com.zhaowei.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/11/26 16:50
 * @Description:
 * @Modified By:
 */
@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        return applicationName+port;
    }

}
