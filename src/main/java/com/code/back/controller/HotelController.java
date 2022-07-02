package com.code.back.controller;


import com.code.back.mapper.HotelCourseVoMapper;
import com.code.back.pojo.Hotel;
import com.code.back.pojo.Msg;
import com.code.back.service.HaddressService;
import com.code.back.service.HotelService;
import com.code.back.util.ControllerUtils;
import com.code.back.util.jsonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Qualifier("HotelServiceImpl")
    private HotelService hotelService;

    @Autowired
    private HotelCourseVoMapper hotelCourseVoMapper;

    @Autowired
    @Qualifier("HaddressServiceImpl")
    private HaddressService haddressService;

    @RequestMapping(value = "/queryhotelbysome", produces = "application/json;charset=utf-8")
    public String queryHotelBySome(@RequestParam(value = "hname",defaultValue = "") String hname,
                                   @RequestParam(value = "rating",defaultValue = "选项2") String star,
                                   @RequestParam(value = "keyword",defaultValue = "") String keyWord,
                                   HttpServletRequest request){

        float starrating = ControllerUtils.starConversion(star);
        HttpSession session = request.getSession();
        session.setAttribute("hname",hname);
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

    @RequestMapping(value = "/viewdetails", produces = "application/json;charset=utf-8")
    public String hotelAllInfo(@Param("h_id") Long hid){
        Msg msg = new Msg();
        msg.setResult("false");
        Hotel hotel = hotelService.queryHotelByhid(hid);
        msg.setResult(hotel);
        return jsonUtil.getJson(msg);
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
    public String screenHotel(@RequestParam(value = "star_rating" ,defaultValue = "3")String  star,
                              @RequestParam(value = "rating_avg" ,defaultValue = "7") float rating,
                              @RequestParam(value = "number_of_review" ,defaultValue ="50")int numreview,
                              @RequestParam(value = "rtname" ,defaultValue = "")String rtname,
                              @RequestParam(value = "order_by", defaultValue = "avg_price")String orderBy,
                              HttpServletRequest request){
        Msg msg = new Msg();
        HttpSession session = request.getSession();
        String  hname = (String) session.getAttribute("hname");
        float st = ControllerUtils.starConversion(star);
        List<Hotel> hotels = hotelService.screenHotel(hname, st, rating, numreview, rtname, orderBy);
        msg.setResult(hotels);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/addhotel", produces = "application/json;charset=utf-8")
    public String addHotel(@RequestParam("hname")String hname,@RequestParam("star_rating")float star,
                           @RequestParam("overview")String overview,
                           @RequestParam("address_line")String addressline,
                           @RequestParam("country")String country,
                           @RequestParam("state")String state,
                           @RequestParam("city")String city) {
        Msg msg = new Msg();
        Long hid = hotelService.addHotel(hname, star, overview);
        haddressService.addHaddress(hid,addressline,country,state,city);
        msg.setResult("success");
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/changehotel", produces = "application/json;charset=utf-8")
    public String changeHotel(@RequestParam("h_id")Long hid,
                              @RequestParam("hname")String hname,@RequestParam("star_rating")float star,
                              @RequestParam("overview")String overview,
                              @RequestParam("address_line")String addressline,
                              @RequestParam("country")String country,
                              @RequestParam("state")String state,
                              @RequestParam("city")String city){
        Msg msg = new Msg();
        msg.setResult("success");
        hotelService.changeHotel(hid,hname,star,overview);
        haddressService.changeHaddress(hid,addressline,country,state,city);
        return jsonUtil.getJson(msg);
    }

    @RequestMapping(value = "/deletehotel", produces = "application/json;charset=utf-8")
    public String deleteHotel(@RequestParam("h_id")Long hid){
        Msg msg = new Msg();
        msg.setResult("success");
        int i = hotelService.deleteHotelByHid(hid);
        if(i == 0){
            msg.setResult("false");
        }
        return jsonUtil.getJson(msg);
    }
}

