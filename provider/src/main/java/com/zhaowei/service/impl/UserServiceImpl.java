package com.zhaowei.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhaowei.entity.SysUser;
import com.zhaowei.mapper.SystemUserMapper;
import com.zhaowei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    SystemUserMapper systemUserMapper;
    @Value("${sss}")
    private String SOURCE;
    @Override
    //@HystrixCommand(fallbackMethod = "fallback")
    public SysUser findById(String userId){
        System.out.println(SOURCE);
        SysUser sysUser = systemUserMapper.queryById(userId);
        if(sysUser == null){
            throw new RuntimeException("1111");
        }
        return sysUser;
    }

    public SysUser fallback(String id) {
        return new SysUser().setUser_id(id);
    }


}
