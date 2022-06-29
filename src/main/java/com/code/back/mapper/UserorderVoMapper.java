package com.code.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.code.back.Vo.UserorderVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserorderVoMapper extends BaseMapper<UserorderVo> {

    public List<UserorderVo> queryAllOrderByUid(Long uid);

    public List<UserorderVo> queryAllStateOrderById(Long uid,int state);

    public UserorderVo queryUserorderByOid(Long oid);
}
