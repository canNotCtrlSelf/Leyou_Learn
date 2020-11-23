package com.cncs.controller;

import com.cncs.client.UserClient;
import com.cncs.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("customer/user")
//@DefaultProperties(defaultFallback = "fallbackMethod")
public class UserController {

    @Autowired
    private UserClient userClient;

    //@Autowired
    //private RestTemplate restTemplate;

    //@Autowired
    //private DiscoveryClient discoveryClient; //// eureka客户端，可以获取到eureka中服务的信息

/*    @RequestMapping("{id}")
    public User queryUserById(@PathVariable("id")Integer id){
        //return restTemplate.getForObject("http://localhost:9091/user/"+id,User.class);
        //List<ServiceInstance> instances = discoveryClient.getInstances("service-provider"); //获根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
        //ServiceInstance serviceInstance = instances.get(0);//因为只有一个Service-provider。所以获取第一个实例
        //return restTemplate.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id,User.class); //解决硬编码问题
        return restTemplate.getForObject("http://service-provider/user/"+id,User.class); //解决硬编码问题
    }*/

    @RequestMapping("{id}")
    @ResponseBody
    //@HystrixCommand //配置了全局熔断方法就不用配置fallbackMethod参数,但是注解必须加上
    //@HystrixCommand(fallbackMethod = "queryUserByIdFallback") // 指定局部熔断的方法
    public User queryUserById(@PathVariable("id") Integer id) {
        //if (id == 1) {
        //    throw new RuntimeException("请求的id不存在！");
        //}
        //return restTemplate.getForObject("http://service-provider/user/" + id, String.class); //解决硬编码问题
        return userClient.findById(id);
    }

    //局部熔断方法
/*    public String queryUserByIdFallback(Integer id){
        return "请求的服务已经超时！";
    }*/
    public String fallbackMethod() {
        return "请求的服务已经超时！";
    }
}
