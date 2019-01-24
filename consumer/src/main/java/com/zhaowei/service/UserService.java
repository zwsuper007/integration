package com.zhaowei.service;

import com.zhaowei.entity.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/11/20 11:58
 * @Description:
 * @Modified By:
 */
@FeignClient(value = "zhaowei-provider",fallbackFactory = UserServiceClientFallbackFactory.class)
public interface UserService {
    @RequestMapping(value = "/selectUser",method = RequestMethod.GET)
    public SysUser selectUser(@RequestParam("userId")String userId);
}
