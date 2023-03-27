package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTestDemo {
    @Autowired
    private UserService userService;
    @Test
    public void query1(){
        List<User> list = userService.list();
        System.out.println(list);
    }
}
