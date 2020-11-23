package com.cncs.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //在引导类加上这个注解，可以启动eureka服务端
public class CncsServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CncsServiceEurekaApplication.class, args);
    }

}
