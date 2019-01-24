package com.zhaowei.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
*@name:WebSecurityConfig
*@date:2018/1/19 17:34
*@package:com.mytian.eureka
*@version:V1.0
*@description:TODO
*@author:xiaotian.zhang
*@modify by:
*/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Value("${users.admin.name}")
    private String admin_name;
    @Value("${users.admin.password}")
    private String admin_password;
    @Value("${users.admin.roles}")
    private String [] admin_roles;

    @Value("${users.pc.name}")
    private String pc_name;
    @Value("${users.pc.password}")
    private String pc_password;
    @Value("${users.pc.roles}")
    private String [] pc_roles;

    @Value("${users.provider.name}")
    private String provider_name;
    @Value("${users.provider.password}")
    private String provider_password;
    @Value("${users.provider.roles}")
    private String [] provider_roles;

    @Value("${users.consumer.name}")
    private String consumer_name;
    @Value("${users.consumer.password}")
    private String consumer_password;
    @Value("${users.consumer.roles}")
    private String [] consumer_roles;

    @Value("${users.zuul.name}")
    private String zuul_name;
    @Value("${users.zuul.password}")
    private String zuul_password;
    @Value("${users.zuul.roles}")
    private String [] zuul_roles;

    @Value("${users.eureka.name}")
    private String eureka_name;
    @Value("${users.eureka.password}")
    private String eureka_password;
    @Value("${users.eureka.roles}")
    private String [] eureka_roles;

    @Value("${users.config.name}")
    private String config_name;
    @Value("${users.config.password}")
    private String config_password;
    @Value("${users.config.roles}")
    private String [] config_roles;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //这里忽略app调用的接口服务,让接口服务的Oauth去验证
        web.ignoring().antMatchers("/app-server/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
        http.authorizeRequests().anyRequest().fullyAuthenticated().antMatchers("/app-server/pc/**").hasRole("PCSERVER");
//        .antMatchers("/app-server/api/**").hasRole("APIUSER");
        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }




    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication().withUser(admin_name).password(admin_password).roles(admin_roles)
                .and().withUser(pc_name).password(pc_password).roles(pc_roles)//PC 服务
                .and().withUser(provider_name).password(provider_password).roles(provider_roles)//服务提供者
                .and().withUser(zuul_name).password(zuul_password).roles(zuul_roles) //路由
                .and().withUser(consumer_name).password(consumer_password).roles(consumer_roles)//消费者
                .and().withUser(eureka_name).password(eureka_password).roles(eureka_roles)//注册中心
        .and().withUser(config_name).password(config_password).roles(config_roles);//配置中心
    }

}
