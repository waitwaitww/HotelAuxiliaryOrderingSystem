package com.code.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.code.back.Vo.HotelCourseVo;


public interface HotelCourseVoService extends IService<HotelCourseVo> {

    //
    HotelCourseVo queryHotelByhid(Long hid);
}
