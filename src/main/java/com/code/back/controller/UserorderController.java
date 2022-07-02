package com.code.back.controller;


import com.code.back.Vo.UserorderVo;
import com.code.back.config.AlipayConfig;
import com.code.back.pojo.*;
import com.code.back.service.*;
import com.code.back.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
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

    @Autowired
    @Qualifier("ReviewServiceImpl")
    private ReviewService reviewService;

    @RequestMapping("/t1")
    public String test(Long uid) {
        List<UserorderVo> list = userorderService.queryAllUserorderByUId(uid);
        list.forEach(System.out::println);
        return "index";
    }

    @RequestMapping("/t3")
    public String test1() {
        userorderService.queryAllReviewByHid(41324L);
        return "index";
    }

    @RequestMapping(value = "/addorder", produces = "application/json;charset=utf-8")
    public String addOrder(HttpServletRequest request, @RequestParam("rid") Long rid,
                           @RequestParam("num") int num, @RequestParam("pname1") String pname1,
                           @RequestParam("p1_tel") Long p1_tel, @RequestParam(value = "pname2",defaultValue = "") String pname2,
                           @RequestParam(value="p2_tel",defaultValue = "") Long p2_tel) {
        Roomtype room = roomtypeService.queryRoomtype(rid);
        Msg msg = new Msg();
        msg.setResult("false");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Long uid = user.getUId();
        if (room.getSurplusroomnum() > 1) {
            Userorder userorder = new Userorder();
            userorder.setRId(room.getRId());
            userorder.setUId(uid);
            userorder.setTotalPrice(room.getRprice() * num);
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

    @RequestMapping(value = "/queryallorderforsb", produces = "application/json;charset=utf-8")
    public String queryAllOrderForSb(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user1 = (User) session.getAttribute("user");
        Long uid = user1.getUId();
        int user = userService.isUserExistByUid(uid);
        Msg msg = new Msg();
        msg.setResult("用户不存在！");
        if (user == 1) {
            List<UserorderVo> userorders = userorderService.queryAllUserorderByUId(uid);
            msg.setResult(userorders);
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/querystateorderforsb", produces = "application/json;charset=utf-8")
    public String queryStateOrderForSb(@RequestParam("state") int state,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user1 = (User) session.getAttribute("user");
        Long uid = user1.getUId();
        int user = userService.isUserExistByUid(uid);
        Msg msg = new Msg();
        msg.setResult("用户不存在！");
        if (user == 1) {
            List<UserorderVo> userorders = userorderService.queryAllStateOrderById(uid, state);
            msg.setResult(userorders);
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/checkin", produces = "application/json;charset=utf-8")
    public String checkIn(@RequestParam("o_id") Long oid) {
        Msg msg = new Msg();
        msg.setResult("success");
        int i = userorderService.updateCheckInOrder(oid);
        if (i == 0) {
            msg.setResult("false");
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/checkout", produces = "application/json;charset=utf-8")
    public String checkOut(@RequestParam("o_id") Long oid) {
        Msg msg = new Msg();
        msg.setResult("success");
        int i = userorderService.updateCheckOutOrder(oid);
        if (i == 0) {
            msg.setResult("false");
        }
        Userorder userorder = userorderService.quserOrederByOid(oid);
        roomtypeService.increaseRoomtypeByRid(userorder.getRId());
        Roomtype roomtype = roomtypeService.queryRoomtype(userorder.getRId());
        roomsumService.increaseRoomsumByHid(roomtype.getHId());
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/comment", produces = "application/json;charset=utf-8")
    public String comment(@RequestParam("o_id") Long oid, @RequestParam("rating") float rating, @RequestParam("review") String review) {
        Msg msg = new Msg();
        msg.setResult("success");
        Userorder userorder = userorderService.quserOrederByOid(oid);
        int comment = userorderService.comment(oid, rating, review);
        if (comment == 0) {
            msg.setResult("false");
        }
        Roomtype roomtype = roomtypeService.queryRoomtype(userorder.getRId());
//        reviewService.addnumber(roomtype.getHId());
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/cancellationorder", produces = "application/json;charset=utf-8")
    public String cancellationOrder(@RequestParam("o_id") Long oid, AliPay aliPay) {
        Msg msg = new Msg();
        msg.setResult("success");
        Userorder userorder = userorderService.quserOrederByOid(oid);
        if (userorder.getState() == 0) {
            int i = userorderService.deleteUserorderById(oid);
            if (i == 0) {
                userorderService.deleteUserorderById(userorder.getOId());
                roomtypeService.increaseRoomtypeByRid(userorder.getRId());
                Roomtype roomtype = roomtypeService.queryRoomtype(userorder.getRId());
                roomsumService.increaseRoomsum(roomtype.getHId());
            } else {
                msg.setResult("false");
            }
        }
        return jsonUtil.getJson(msg);
    }
}

