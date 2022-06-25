package com.code.back.mapper;

import com.code.back.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ?û?? Mapper 接口
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("select upassword from haos.user where u_id = ${u_id}")
    public String  queryPasswordByid(@Param("u_id") Integer uId);

    //更新用户密码
    @Update("update haos.user set upassword=${upassword} where u_id=${u_id}")
    public int updateUpassword(@Param("u_id")Integer uid,@Param("upassword")String password);

}
