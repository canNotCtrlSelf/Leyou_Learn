package com.cncs.controller;

import com.cncs.pojo.User;
import com.cncs.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<User> users= userService.queryAll();
        mv.addObject("users",users);
        mv.setViewName("users");
        return mv;
    }

    @RequestMapping("/hello/{id}")
    @ResponseBody
    public User hello(@PathVariable(name = "id")Integer id){
        //System.out.println("hello is running...");
        //log.warn("hello is running...");

        User user = userService.queryById(id);
        //return "hello SpringBoot !";
        return user;
    }
}
