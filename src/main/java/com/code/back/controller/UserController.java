package com.code.back.controller;


import com.code.back.pojo.Msg;
import com.code.back.pojo.User;
import com.code.back.service.UserService;
import com.code.back.util.jsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ?û?? 前端控制器
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@RestController
@RequestMapping("/back/user")
public class UserController {


    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping("/t1")
    public String testSpringBoot() {
        userService.loginEmail("2075831247@qq.com");
        return "index";
    }

//    @RequestMapping(value = "/loginById",produces = "application/json;charset=utf-8")
//    public String loginId(@RequestParam("uid")Long uid, @RequestParam("upassword")String password){
////        String pwdById = userService.queryPwdById(uid);
//        if(pwdById.equals(password)) {
//            return jsonUtil.getJson("true");
//        }
//        else return jsonUtil.getJson("false");
//    }

    @RequestMapping(value = "/t2",produces = "application/json;charset=utf-8")
    public String loginEmail(@RequestParam("uname")String  email, @RequestParam("upassword")String password){
//        String pwdById = userService.queryPwdByEmail(email);
        String pwdById = userService.queryPwdByEmail(email);
        List<User> users = new ArrayList<>();
        String msg = "false";

        Msg msg1 = new Msg();
        msg1.setResult(msg);

        System.out.println("email");
        if(pwdById.equals(password)) {
            System.out.println(password);
            msg1.setResult("success");
            return jsonUtil.getJson(msg1);
        }

        else return jsonUtil.getJson(msg1);
    }


//    @AuthAccess
    @RequestMapping("/sendemailcode")
    public String sendEmailCode(@Param("email") String email){
        String s = userService.loginEmail(email);
        Msg msg = new Msg();
        msg.setResult("邮件发送成功");
        if(s.equals(null)){
            msg.setResult("邮件发送失败");
        }
        return jsonUtil.getJson(msg);
    }
}

