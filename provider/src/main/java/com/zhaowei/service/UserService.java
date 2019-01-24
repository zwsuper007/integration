package com.zhaowei.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhaowei.entity.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserService {

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    SysUser findById(String userId);


}
