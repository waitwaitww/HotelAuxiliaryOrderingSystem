package com.code.back.controller;


import com.code.back.pojo.Msg;
import com.code.back.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * ????Ա? 前端控制器
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@RestController
@RequestMapping("/back/admin")
public class AdminController {

    @Autowired
    @Qualifier("AdminServiceImpl")
    private AdminService adminService;

    @RequestMapping(value = "/login" ,produces ="application/json;charset=utf-8" )
    public String adminLogin(@RequestParam("aname")String aname,@RequestParam("apassword") String apassword){
        Msg msg = new Msg();
        msg.setResult("false");
        String pwd = adminService.queryAPwdByAname(aname);
        if (pwd == apassword){
            msg.setResult("success");
        }
        return null;
    }
}

