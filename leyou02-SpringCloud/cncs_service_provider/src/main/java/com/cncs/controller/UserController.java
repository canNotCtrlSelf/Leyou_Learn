package com.cncs.controller;

import com.cncs.pojo.User;
import com.cncs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    public User findById(@PathVariable("id")Integer id){
       /* try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return userService.queryById(id);
    }
}
