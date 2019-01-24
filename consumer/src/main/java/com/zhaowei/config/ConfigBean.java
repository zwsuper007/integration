package com.zhaowei.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: wei.zhao
 * @Date: Create in  2018/11/20 11:43
 * @Description:
 * @Modified By:
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplete(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){ return new RoundRobinRule();}

}
