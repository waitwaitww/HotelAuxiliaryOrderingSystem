package com.code.back.controller;


import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alipay.api.internal.util.AlipaySignature;
import com.code.back.Vo.UserorderVo;
import com.code.back.config.AlipayConfig;
import com.code.back.pojo.AliPay;
import com.code.back.pojo.Msg;
import com.code.back.pojo.Roomtype;
import com.code.back.pojo.Userorder;
import com.code.back.service.*;
import com.code.back.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    @Qualifier("RoomsumServiceImpl")
    private RoomsumService roomsumService;

    @Resource
    AlipayConfig aliPayConfig;


    @RequestMapping("/t1")
    public String test(Long uid){
        List<UserorderVo> list = userorderService.queryAllUserorderByUId(uid);
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
            userorder.setCreateTime(new Date());
            userorderService.addUserorder(userorder);
            msg.setResult(userorder);
            roomtypeService.reduceRoomtypeByRid(rid);
            Long hid = roomtypeService.queryRoomtype(rid).getHId();
            roomsumService.reduceRoomsumByHid(hid);
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryallorderforsb",produces = "application/json;charset=utf-8")
    public String queryAllOrderForSb(@RequestParam("u_id") Long uid){
        int user = userService.isUserExistByUid(uid);
        Msg msg = new Msg();
        msg.setResult("用户不存在！");
        if(user == 1){
            List<UserorderVo> userorders = userorderService.queryAllUserorderByUId(uid);
            msg.setResult(userorders);
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/querystateorderforsb",produces = "application/json;charset=utf-8")
    public String queryStateOrderForSb(@RequestParam("u_id") Long uid,@RequestParam("state") int state){
        int user = userService.isUserExistByUid(uid);
        Msg msg = new Msg();
        msg.setResult("用户不存在！");
        if(user == 1){
            List<UserorderVo> userorders = userorderService.queryAllStateOrderById(uid,state);
            msg.setResult(userorders);
        }
        return jsonUtil.getJson(msg);
    }



    @RequestMapping(value = "/checkin",produces = "application/json;charset=utf-8")
    public String checkIn(@RequestParam("o_id") Long oid){
        Msg msg = new Msg();
        msg.setResult("success");
        int i = userorderService.updateCheckInOrder(oid);
        if(i == 0){
            msg.setResult("false");
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/checkout",produces = "application/json;charset=utf-8")
    public String checkOut(@RequestParam("o_id")Long oid){
        Msg msg = new Msg();
        msg.setResult("success");
        int i = userorderService.updateCheckOutOrder(oid);
        if(i == 0){
            msg.setResult("false");
        }
        Userorder userorder = userorderService.quserOrederByOid(oid);
        roomtypeService.increaseRoomtypeByRid(userorder.getRId());
        Roomtype roomtype = roomtypeService.queryRoomtype(userorder.getRId());
        roomsumService.increaseRoomsumByHid(roomtype.getHId());
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/comment",produces = "application/json;charset=utf-8")
    public String comment(@RequestParam("o_id")Long oid,@RequestParam("rating")float rating,@RequestParam("review")String review){
        Msg msg = new Msg();
        msg.setResult("success");
        int comment = userorderService.comment(oid, rating, review);
        if(comment == 0){
            msg.setResult("false");
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/cancellationorder",produces = "application/json;charset=utf-8")
    public String cancellationOrder(@RequestParam("o_id")Long oid, AliPay aliPay){
        Msg msg = new Msg();
        msg.setResult("success");
        Userorder userorder = userorderService.quserOrederByOid(oid);
        if(userorder.getState() == 0){
            int i = userorderService.deleteUserorderById(oid);
            if(i == 0){
                userorderService.deleteUserorderById(userorder.getOId());
                roomtypeService.increaseRoomtypeByRid(userorder.getRId());
                Roomtype roomtype = roomtypeService.queryRoomtype(userorder.getRId());
                roomsumService.increaseRoomsum(roomtype.getHId());
            }
            else{
                msg.setResult("false");
            }
        }
        return jsonUtil.getJson(msg);
    }
}

