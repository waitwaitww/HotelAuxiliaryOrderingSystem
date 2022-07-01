package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Hotel;
import com.code.back.mapper.HotelMapper;
import com.code.back.service.HotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ?Ƶ?? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("HotelServiceImpl")
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;

    public HotelMapper getHotelMapper() {
        return hotelMapper;
    }

    public void setHotelMapper(HotelMapper hotelMapper) {
        this.hotelMapper = hotelMapper;
    }

    @Override
    public List<Hotel> queryAllHotel() {
        return hotelMapper.queryAllHotel();
    }

    @Override
    public Hotel queryHotelByhid(Long hid) {
        return hotelMapper.queryAllInforByHid(hid);
    }

    @Override
    public List<Hotel> queryGtstar(float star) {
        QueryWrapper<Hotel> wrapper = new QueryWrapper<>();
        wrapper.gt("star_rating",star);
        return hotelMapper.selectList(wrapper);
    }

    @Override
    public int deleteHotelByHid(Long hid) {
        return hotelMapper.deleteById(hid);
    }

    @Override
    public List<Hotel> queryGtReviewsum(int review_num) {
        return hotelMapper.queryGtReviewsum(review_num);
    }

    @Override
    public List<Hotel> qeuryHotelBySome(Map<String, Object> some) {
        String hname = (String) some.get("hname");
        float star_rating = (float) some.get("star_rating");
        String keyWord = (String) some.get("keyword");
        List<Hotel> hotels = new ArrayList<>();
        if(star_rating >3.0){
            hotels= hotelMapper.queryHotelBySome1("%" + hname + "%", star_rating, keyWord);
        }
        else{
            hotels = hotelMapper.queryHotelBySome2("%" + hname + "%", star_rating, keyWord);
        }

        //        if (hotels.size() > 0)
        return hotels;
    }

    @Override
    public List<Hotel> queryHotelByDistance(float distance) {
        return hotelMapper.qeuryHotelBydistence(distance);
    }
}
