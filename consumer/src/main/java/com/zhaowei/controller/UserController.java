package com.zhaowei.controller;

import com.zhaowei.entity.SysUser;
import com.zhaowei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/11/20 11:47
 * @Description:
 * @Modified By:
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    @ResponseBody
    public SysUser selectUser(@RequestParam(value = "userId")String userId){
        System.out.println("************************"+userId);
        //return restTemplate.getForObject("http://zhaowei-provider:8081/selectUser?userId="+userId,SysUser.class);
        return  userService.selectUser(userId);
    }
}
