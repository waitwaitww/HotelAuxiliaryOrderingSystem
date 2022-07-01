package com.code;


import com.code.back.Vo.HotelCourseVo;
import com.code.back.Vo.UserorderVo;
import com.code.back.mapper.HotelCourseVoMapper;
import com.code.back.mapper.HotelMapper;
import com.code.back.mapper.UserorderVoMapper;
import com.code.back.pojo.Hotel;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.List;

@SpringBootTest
@ServletComponentScan
@MapperScan("com.code.back.mapper")
class DemoApplicationTests {

    @Autowired
    HotelMapper hotelMapper;

    @Test
    void contextLoads() {
        List<Hotel> hotels = hotelMapper.qeuryHotelBydistence(20000);
        hotels.forEach(System.out::println);
    }

}
