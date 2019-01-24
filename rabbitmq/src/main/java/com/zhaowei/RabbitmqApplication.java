package com.zhaowei;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@SpringCloudApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
@EnableTransactionManagement
@ServletComponentScan
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Configuration
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue("sensors.hello");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("sensors");
    }
    @Bean
    public Binding bindingExchangeMessage(Queue queue , TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("sensors.#");
    }
}
