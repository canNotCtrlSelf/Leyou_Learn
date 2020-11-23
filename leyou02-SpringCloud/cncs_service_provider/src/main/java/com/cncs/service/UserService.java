package com.cncs.service;

import com.cncs.mapper.UserMapper;
import com.cncs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }
}
