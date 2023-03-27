package com.atguigu;
import com.atguigu.entity.User;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryTestDemo {
    @Autowired
    private UserMapper userMapper;
    //1.queryWrapper实现条件查询
    @Test
    public void query1(){
        //创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //ge为例有两个参数：第一个参数表字段名称,第二个参数值
        //ge是大于等于
        wrapper.ge("age",20);
        //调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
    @Test
    public void query2(){
        //创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //ge为例有两个参数：第一个参数表字段名称,第二个参数值
        //ge是大于等于
        wrapper.eq("name","上海上海");
        //调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
    @Test
    //模糊查询
    public void query3(){
        //创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //ge为例有两个参数：第一个参数表字段名称,第二个参数值
        //ge是大于等于
        wrapper.like("name","上海");
        //调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
    @Test
    //模糊查询
    public void query4(){
        //创建条件构造对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //ge为例有两个参数：第一个参数表字段名称,第二个参数值
        //ge是大于等于
        wrapper.orderByDesc("id");
        //调用方法实现条件查询
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }
}
