package com.zhaowei.service;

import com.zhaowei.entity.SysUser;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/11/23 17:55
 * @Description:
 * @Modified By:
 */
@Component
public class UserServiceClientFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public SysUser selectUser(String userId) {
                return new SysUser().setUser_id("kong");
            }
        };
    }
}
