package com.cncs.client;

import com.cncs.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("请求的服务暂不可用！");
        return user;
    }
}
