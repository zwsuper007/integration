package com.zhaowei.service;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

public interface UserService {

    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
     void findById(String userId);

    @RequestMapping(value = "/createDeployment", method = RequestMethod.POST)
    void createDeployment();


}
