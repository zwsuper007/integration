package com.zhaowei.service.impl;

import com.zhaowei.service.UserService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2019/1/18 14:17
 * @Description:
 * @Modified By:
 */
@RestController
public class UserServiceImpl implements UserService {
    @Override
    public void findById(String userId) {
        System.out.println(userId);
    }

    @Override
    public void createDeployment() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagram/holiday.bpmn")
                .addClasspathResource("diagram/holiday.png")
                .name("请假申请单流程")
                .deploy();
        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }
}
