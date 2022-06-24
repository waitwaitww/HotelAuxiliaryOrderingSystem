package com.code;


import com.code.back.controller.UserController;
import com.code.back.mapper.UserMapper;
import com.code.back.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.List;

@SpringBootTest
@ServletComponentScan
@MapperScan("com.code.back.mapper")
class DemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
        val users = userMapper.selectList(null);
        users.forEach(System.out::println);
        User user = new User();
        user.setUname("hxl");
        user.setEmail("324523452@qq.com");
        user.setUpassword("333222111");
        user.setSex(false);
        user.setShot(1);
        user.setUserDescribe("项目经理");
        user.setAge(3);
        userMapper.insert(user);
    }

    @Test
    void testqianhou(){
//        userController.testSpringBoot();
    }

}
