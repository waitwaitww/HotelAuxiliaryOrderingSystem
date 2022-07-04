package com.code.back.controller;


import cn.hutool.core.date.DateUtil;
import com.alipay.api.internal.util.AlipaySignature;
import com.code.back.Vo.UserorderVo;
import com.code.back.config.AlipayConfig;
import com.code.back.pojo.*;
import com.code.back.service.*;
import com.code.back.util.ControllerUtils;
import com.code.back.util.jsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Autowired
    @Qualifier("ReviewServiceImpl")
    private ReviewService reviewService;

    private static final String GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    private static final String FORMAT = "JSON";
    private static final String CHARSET = "UTF-8";
    //签名方式
    private static final String SIGN_TYPE = "RSA2";

    @Resource
    private AlipayConfig aliPayConfig;

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
                           @RequestParam("num") String  num, @RequestParam("pname1") String pname1,
                           @RequestParam("p1_tel") Long p1_tel, @RequestParam(value = "pname2",defaultValue = "") String pname2,
                           @RequestParam(value="p2_tel",defaultValue = "") Long p2_tel) {
        Roomtype room = roomtypeService.queryRoomtype(rid);
        Msg msg = new Msg();
        msg.setResult("false");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int rnum = ControllerUtils.setnum(num);
//        Long uid = 1541968756951871489L;
        Long uid = user.getUId();
        if (room.getSurplusroomnum() > 1) {
            Userorder userorder = new Userorder();
            userorder.setRId(room.getRId());
            userorder.setUId(uid);
            userorder.setTotalPrice(room.getRprice() * rnum);
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
//        Long uid = 1541968756951871489L;
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
    public String checkIn(@RequestParam("o_id") String  oid) {
        Msg msg = new Msg();
        msg.setResult("success");
        int i = userorderService.updateCheckInOrder(oid);
        if (i == 0) {
            msg.setResult("false");
        }
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/checkout", produces = "application/json;charset=utf-8")
    public String checkOut(@RequestParam("o_id") String oid) {
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
    public String comment(@RequestParam("o_id") String oid, @RequestParam("rating") float rating, @RequestParam("review") String review) {
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
    public String cancellationOrder(@RequestParam("o_id") String oid) {
        Msg msg = new Msg();
        msg.setResult("success");
        Userorder userorder = userorderService.quserOrederByOid(oid);
        if (userorder.getState() == 0) {
            int i = userorderService.deleteUserorderById(oid);
            if (i == 1) {
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

    @PostMapping(value = "/notify")  // 注意这里必须是POST接口
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
            String now = DateUtil.now();
            Date payTime = DateUtil.parseDateTime(now);
            String sign = params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            boolean checkSignature = AlipaySignature.rsa256CheckContent(content, sign, aliPayConfig.getAlipayPublicKey(), "UTF-8"); // 验证签名
            // 支付宝验签
            if (checkSignature) {
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
                int i = userorderService.updateSuccessPay(tradeNo, payTime,alipayTradeNo);
            }
        }
        Msg msg = new Msg();
        msg.setResult("success");
        return jsonUtil.getJson(msg);
    }

}

