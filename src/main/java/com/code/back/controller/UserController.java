package com.code.back.controller;


import com.code.back.pojo.User;
import com.code.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ?û?? 前端控制器
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Controller
@RequestMapping("/back/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/t2")
    @ResponseBody
    public String testSpringBoot(@RequestParam("uname")String Uname,@RequestParam("upassword")String Upassword) {
        System.out.println(Uname);
        System.out.println(Upassword);
        return "index";
    }

    @RequestMapping("/t1")
    public String verifyIdentity(Long uid, String password, Model model){

        return "success";
    }
}

