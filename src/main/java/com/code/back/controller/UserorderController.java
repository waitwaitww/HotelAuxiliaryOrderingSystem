package com.code.back.controller;


import com.alipay.easysdk.factory.Factory;
import com.code.back.Vo.UserorderVo;
import com.code.back.pojo.Msg;
import com.code.back.pojo.Roomtype;
import com.code.back.pojo.User;
import com.code.back.pojo.Userorder;
import com.code.back.service.*;
import com.code.back.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            userorderService.addUserorder(userorder);
            msg.setResult(userorder);
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

    @PostMapping(value = "/notify",produces = "application/json;charset=utf-8")  // 注意这里必须是POST接口
    public String payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
                // System.out.println(name + " = " + request.getParameter(name));
            }

            String tradeNo = params.get("out_trade_no");
            String gmtPayment = params.get("gmt_payment");
            String alipayTradeNo = params.get("trade_no");
            Date payTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(params.get("gmt_payment"));
            // 支付宝验签
            if (Factory.Payment.Common().verifyNotify(params)) {
                // 验签通过
                System.out.println("交易名称: " + params.get("subject"));
                System.out.println("交易状态: " + params.get("trade_status"));
                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
                System.out.println("买家付款时间: " + params.get("gmt_payment"));
                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));

                // 更新订单未已支付
                int i = userorderService.updateSuccessPay(Long.valueOf(tradeNo), payTime);
//                userorderService.(tradeNo, "已支付", gmtPayment, alipayTradeNo);
            }
        }
        return "success";
    }

//    @RequestMapping(value = "/queryallorderforsb",produces = "application/json;charset=utf-8")
//    public String query
}

