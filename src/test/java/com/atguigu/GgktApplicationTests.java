package com.atguigu;

import com.atguigu.entity.User;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class GgktApplicationTests {
    //注入mapper
    @Autowired
    private UserMapper userMapper;
    //1.查询表所有数据
    @Test
    public void findAll() {
        List<User> userList = userMapper.selectList(null);
        for (User user:userList) {
            System.out.println(user);

        }

    }
    //2.添加操作
    @Test
    public void addUser(){
        User user = new User();
        user.setName("尚硅谷upup");
        user.setAge(10);
        user.setEmail("atguigu.com");
        int rows = userMapper.insert(user);
        System.out.println("rows:"+rows);
        //添加成功之后，把添加之后生成的id值，回填到user对象里面
        System.out.println(user);
    }
    //3.修改操作
    @Test
    public void updateUser(){
        // 根据id查询
        User user = userMapper.selectById(1640162926854475778L);
        //设置修改值
        user.setName("上海上海");
        //调用方法实现修改
        int rows = userMapper.updateById(user);
        System.out.println(rows);
    }
    //4.分页查询
//    @Test
//    public void findPage(){
//        //创建Page对象，传递两个参数：当前页 每页显示的记录数
//        Page<User> page = new Page<>(1,3);
//        //调用mp中的方法实现分页
//        userMapper.selectPage(page,null);
////        IPage<User> pageModel = userMapper.selectPage(page,null);
//        page.getRecords();//每页的集合
//        page.getTotal();//总记录数
//        page.getPages();//总页数
//        page.getSize();//显示多少条记录
//        page.getCurrent();//当前页
//        page.hasNext();//是否有下一页
//        page.hasPrevious();//是否有上一页
//
//    }
    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
    //5 id删除
    @Test
    public void deleteID(){
        int rows = userMapper.deleteById(1640209819290632193L);//返回的是影响的行数
    }
    //6 批量删除
    @Test
    public void deleteBatch(){
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        int rows = userMapper.deleteBatchIds(list);
        // 第二种传入list的方式
//        userMapper.deleteBatchIds(Arrays.asList(3));
        System.out.println(rows);
    }


}
