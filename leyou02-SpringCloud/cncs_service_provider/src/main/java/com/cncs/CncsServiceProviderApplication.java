package com.cncs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.cncs.mapper")
@EnableDiscoveryClient //启动eureka的客户端，@EnableDiscoveryClient是由spring-cloud提供的注解（兼容性更更好，推介使用）。也可以用@EnableEurekaClient，它是由netfix提供的
public class CncsServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CncsServiceProviderApplication.class, args);
    }

}
