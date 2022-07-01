package com.code.back.controller;


import com.code.back.mapper.HotelCourseVoMapper;
import com.code.back.pojo.Hotel;
import com.code.back.pojo.Msg;
import com.code.back.service.HotelService;
import com.code.back.util.ControllerUtils;
import com.code.back.util.jsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ?Ƶ?? 前端控制器
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@RestController
@RequestMapping("/back/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelCourseVoMapper hotelCourseVoMapper;

    @RequestMapping(value = "/queryhotelbysome", produces = "application/json;charset=utf-8")
    public String queryHotelBySome(@RequestParam(value = "hname",defaultValue = "") String hname,
                                   @RequestParam(value = "rating",defaultValue = "选项2") String star,
                                   @RequestParam(value = "keyword",defaultValue = "") String keyWord){

        float starrating = ControllerUtils.starConversion(star);
        System.out.println(hname);
        System.out.println(keyWord);
        System.out.println(starrating);
        Map<String ,Object> some = new HashMap<>();
        some.put("hname",hname);
        some.put("star_rating",starrating);
        some.put("keyword",keyWord);
        List<Hotel> hotels = hotelService.qeuryHotelBySome(some);
        Msg msg = new Msg();
        msg.setResult(hotels);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/hotelAllInfo", produces = "application/json;charset=utf-8")
    public String hotelAllInfo(@Param("hid") Long hid){
        return jsonUtil.getJson(hotelService.queryHotelByhid(hid));
//        return jsonUtil.getJson(hotelCourseVoMapper.queryAllInfoByHid(hid));
    }

    @RequestMapping(value = "/queryallhotel", produces = "application/json;charset=utf-8")
    public String queryAllHotel(){
        Msg msg = new Msg();
        List<Hotel> hotels = hotelService.queryAllHotel();
        msg.setResult(hotels);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/queryhotelbydistance", produces = "application/json;charset=utf-8")
    public String queryHotelByDistance(@RequestParam("distance")float distance){
        Msg msg = new Msg();
        List<Hotel> hotels = hotelService.queryHotelByDistance(distance);
        msg.setResult(hotels);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/screenhotel", produces = "application/json;charset=utf-8")
    public String screenHotel(@RequestParam(value = "star_rating" ,defaultValue = "3")float star,
                              @RequestParam(value = "rating_avg" ,defaultValue = "7") float rating,
                              @RequestParam(value = "number_of_review" ,defaultValue ="50")int numreview,
                              @RequestParam(value = "rtname" ,defaultValue = "")String rtname,
                              @RequestParam(value = "order_by", defaultValue = "avg_price")String orderBy){
        Msg msg = new Msg();

        return jsonUtil.getJson(msg);
    }
}

