package com.code.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.back.Vo.HotelCourseVo;
import com.code.back.mapper.HotelCourseVoMapper;
import com.code.back.service.HotelCourseVoService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("HotelCourseVoService")
public class HotelCourseVoServiceImpl extends ServiceImpl<HotelCourseVoMapper, HotelCourseVo> implements HotelCourseVoService {
    @Override
    public HotelCourseVo queryHotelByhid(Long hid) {
        return null;
    }
}
