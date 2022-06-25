package com.code.back.controller;


import com.code.back.pojo.Userorder;
import com.code.back.service.UserorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Controller
@RequestMapping("/back/userorder")
public class UserorderController {


    @Autowired
    @Qualifier("UserorderServiceImpl")
    private UserorderService userorderService;

    @RequestMapping("/t1")
    public String test(Integer uid){
        List<Userorder> list = userorderService.queryAllUserorderByUId(uid);
        list.forEach(System.out::println);
        return "success";
    }
}

