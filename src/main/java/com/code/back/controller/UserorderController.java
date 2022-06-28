package com.code.back.controller;


import com.code.back.pojo.Msg;
import com.code.back.pojo.Roomtype;
import com.code.back.pojo.User;
import com.code.back.pojo.Userorder;
import com.code.back.service.*;
import com.code.back.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RestController
@RequestMapping("/back/userorder")
public class UserorderController {


    @Autowired
    @Qualifier("UserorderServiceImpl")
    private UserorderService userorderService;

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("RoomtypeServiceImpl")
    private RoomtypeService roomtypeService;


    @RequestMapping("/t1")
    public String test(Long uid){
        List<Userorder> list = userorderService.queryAllUserorderByUId(uid);
        list.forEach(System.out::println);
        return "index";
    }


    @RequestMapping("/t3")
    public String test1(){
        userorderService.queryAllReviewByHid(41324L);
        return "index";
    }


    @RequestMapping(value = "/addorder",produces = "application/json;charset=utf-8")
    public String addOrder(@RequestParam("uid") Long uid,@RequestParam("rid") Long rid,
                           @RequestParam("num") int num,@RequestParam("pname1")String pname1,
                           @RequestParam("p1_tel")Long p1_tel,@RequestParam("pname2")String pname2,
                           @RequestParam("p2_tel")Long p2_tel){
        Roomtype room = roomtypeService.queryRoomtype(rid);
        Msg msg = new Msg();
        msg.setResult("false");
        if(room.getSurplusroomnum()>1){
            Userorder userorder = new Userorder();
            userorder.setRId(room.getRId());
            userorder.setUId(uid);
            userorder.setTotalPrice(room.getRprice()*num);
            userorder.setPname1(pname1);
            userorder.setPname2(pname2);
            userorder.setP1Tel(p1_tel);
            userorder.setP2Tel(p2_tel);
            userorderService.addUserorder(userorder);
            msg.setResult(userorder);
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryallorderforsb",produces = "application/json;charset=utf-8")
    public String queryAllOrderForSb(Long uid){
        User user = userService.queryUserById(uid);
        Msg msg = new Msg();
        msg.setResult("用户不存在！");
        if(user.getUId() != null){
            List<Userorder> userorders = userorderService.queryAllUserorderByUId(uid);
            msg.setResult(userorders);
        }
        return jsonUtil.getJson(msg);
    }

}

