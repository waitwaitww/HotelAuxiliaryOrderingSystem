package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Haddress;
import com.code.back.mapper.HaddressMapper;
import com.code.back.service.HaddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ??ַ? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
public class HaddressServiceImpl extends ServiceImpl<HaddressMapper, Haddress> implements HaddressService {

    @Autowired
    private HaddressMapper haddressMapper;

    @Override
    public Haddress queryHaddressByHid(Long hid) {
        QueryWrapper<Haddress> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        return haddressMapper.selectOne(wrapper);
    }
}
