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
    public String queryHotelBySome(@RequestParam("hname") String hname,
                                   @RequestParam("rating") String star,
                                   @RequestParam("keyword") String keyWord){

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
//        return jsonUtil.getJson(hotelService.queryHotelByhid(hid));
        return jsonUtil.getJson(hotelCourseVoMapper.queryAllInfoByHid(hid));
    }
}

