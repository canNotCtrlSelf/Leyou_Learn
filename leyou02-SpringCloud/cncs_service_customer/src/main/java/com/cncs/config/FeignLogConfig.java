package com.cncs.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL; //记录所有的请求和响应的明细，包括头信息，请求体，元数据
    }
}
