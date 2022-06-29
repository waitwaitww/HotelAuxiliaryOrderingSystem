package com.code.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.code.back.Vo.HotelCourseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelCourseVoMapper extends BaseMapper<HotelCourseVo> {

    //查询某酒店所有信息
       public List<HotelCourseVo> queryAllInfoByHid(@Param("h_id") Long hid);
}
