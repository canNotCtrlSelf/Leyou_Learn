package com.cncs.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //开启zuul组件
@EnableDiscoveryClient //开启eureka客户端组件
public class CncsZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CncsZuulApplication.class, args);
    }

}
