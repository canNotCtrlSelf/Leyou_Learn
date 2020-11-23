package com.cncs.service;

import com.cncs.pojo.User;

import java.util.List;

public interface IUserService {
    User queryById(Integer id);

    void insertUser(User user);

    List<User> queryAll();
}
