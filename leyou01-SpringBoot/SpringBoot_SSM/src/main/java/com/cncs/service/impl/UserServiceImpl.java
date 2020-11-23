package com.cncs.service.impl;

import com.cncs.mapper.UserMapper;
import com.cncs.pojo.User;
import com.cncs.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl  implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional //开启事务支持
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> queryAll() {
        return userMapper.selectAll();
    }
}
