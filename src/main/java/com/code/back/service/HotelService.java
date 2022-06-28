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
}
