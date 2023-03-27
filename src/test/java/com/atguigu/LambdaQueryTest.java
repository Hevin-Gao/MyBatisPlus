package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LambdaQueryTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testLambdaQuery1(){
        //创建条件构造对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //ge为例有两个参数：第一个参数表字段名称,第二个参数值
        //ge是大于等于
        // User::getName,"上海上海"表示java8中的写法
        wrapper.eq(User::getName,"上海上海");
        //调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
    @Test
    public void testLambdaQuery2(){
        //创建条件构造对象
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        //ge为例有两个参数：第一个参数表字段名称,第二个参数值
        //ge是大于等于
        // User::getName,"上海上海"表示java8中的写法
        wrapper.like(User::getName,"上海");
        //调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
}
