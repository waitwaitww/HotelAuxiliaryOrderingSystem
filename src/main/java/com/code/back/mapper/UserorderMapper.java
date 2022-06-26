package com.code.back.mapper;

import com.code.back.pojo.Userorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Repository
public interface UserorderMapper extends BaseMapper<Userorder> {

    @Select("select review from haos.userorder where r_id = (select r_id from haos.roomtype where h_id = #{h_id})")
    List<String> selectAllReviewByHid(@Param("h_id") Long hid);
}
