package com.code.back.mapper;

import com.code.back.pojo.Hotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.annotations.SwaggerDefinition;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * ?Ƶ?? Mapper 接口
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Repository
public interface HotelMapper extends BaseMapper<Hotel> {

    @Select("select * from haos.hetol where h_id = (select h_id from haos.review where number_of_review > #{number_of_review}")
    public List<Hotel> queryGtReviewsum(@Param("number_of_review") int reviewsum);

    List<Hotel> queryHotelBySome1(@Param("hname")String hname, @Param("star_rating") float star_rating, @Param("keyWord") String keyWord);

    List<Hotel> queryHotelBySome2(@Param("hname")String hname, @Param("star_rating") float star_rating, @Param("keyWord") String keyWord);

    Hotel queryAllInforByHid(@Param("h_id") Long hid);

    List<Hotel> queryAllHotel();

    List<Hotel> qeuryHotelBydistence(@Param("distance")float distance);
//    List<Hotel> queryAllInf();

}
