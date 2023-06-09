package com.code.back.service;

import com.code.back.pojo.Hotel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ?Ƶ?? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface HotelService extends IService<Hotel> {

    //查询所有酒店信息
    List<Hotel> queryAllHotel();

    //查询某酒店所有信息
    Hotel queryHotelByhid(Long hid);

    //查询星级大于某值的酒店
    List<Hotel> queryGtstar(float star);

    //删除某酒店
    int deleteHotelByHid(Long hid);

    //查询评论数大于某数的酒店
    List<Hotel> queryGtReviewsum(int review_num);

    List<Hotel> qeuryHotelBySome(Map<String, Object> some);

    //根据距离查找
    List<Hotel> queryHotelByDistance(float distance);

    //按照筛选条件查询


    //添加酒店
    Long addHotel(String hname,float star,String overview);

    //更改酒店信息
    int changeHotel(Long hid,String hname,float star,String overview);

    List<Hotel> screenHotel(String hanme,float star, float rating, int numreview, String rtname, String orderBy);
}
