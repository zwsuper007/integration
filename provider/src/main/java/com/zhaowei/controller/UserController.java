package com.zhaowei.controller;


import com.zhaowei.entity.SysUser;
import com.zhaowei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/9/30 16:40
 * @Description:
 * @Modified By:
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient client;

    /*@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    public SysUser selectUser(@RequestParam(value = "userId")String userId){
        //AB96C135E1E44FE39920F0BAB5E231D8
        SysUser sysUser = userService.findById(userId);
        return sysUser;
    }*/

    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("***********"+list);
        List<ServiceInstance> serList = client.getInstances("zhaowei-provider");
        for (ServiceInstance s: serList) {
            System.out.println(s.getServiceId()+"\t"+s.getHost()+"\t"+s.getUri());
        }
        return this.client;
    }


}
