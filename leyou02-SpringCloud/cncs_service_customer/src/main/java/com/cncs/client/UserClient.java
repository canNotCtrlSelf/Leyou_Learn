package com.cncs.client;

import com.cncs.config.FeignLogConfig;
import com.cncs.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value ="service-provider",fallback = UserClientImpl.class,configuration = FeignLogConfig.class) //标注该类是一个feign接口，声明服务降级的方法
public interface UserClient {

    @RequestMapping("user/{id}")
    User findById(@PathVariable("id")Integer id);
}
