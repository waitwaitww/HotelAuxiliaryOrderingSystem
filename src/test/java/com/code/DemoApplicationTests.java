package com.code;


import com.code.back.mapper.HotelMapper;
import com.code.back.pojo.Hotel;
import lombok.val;
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


    @Test
    void contextLoads() {

    }

}
