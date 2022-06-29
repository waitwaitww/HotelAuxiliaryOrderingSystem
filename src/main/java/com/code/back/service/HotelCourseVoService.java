package com.code.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.code.back.CourseVo.HotelCourseVo;
import com.code.back.pojo.Hotel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


public interface HotelCourseVoService extends IService<HotelCourseVo> {

    //
    HotelCourseVo queryHotelByhid(Long hid);
}
