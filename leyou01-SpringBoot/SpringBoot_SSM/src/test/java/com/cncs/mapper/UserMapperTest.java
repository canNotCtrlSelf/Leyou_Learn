package com.cncs.mapper;

import com.cncs.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQuery(){
        //List<User> users = userMapper.selectAll();
        //System.out.println(users);
        User user = userMapper.selectByPrimaryKey(41);
        System.out.println(user);
    }
}