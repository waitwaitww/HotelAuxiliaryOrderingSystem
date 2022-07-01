package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Haddress;
import com.code.back.mapper.HaddressMapper;
import com.code.back.service.HaddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Qualifier("HaddressServiceImpl")
public class HaddressServiceImpl extends ServiceImpl<HaddressMapper, Haddress> implements HaddressService {

    @Autowired
    private HaddressMapper haddressMapper;

    @Override
    public Haddress queryHaddressByHid(Long hid) {
        QueryWrapper<Haddress> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        return haddressMapper.selectOne(wrapper);
    }

    @Override
    public int addHaddress(Long hid,String addressLine, String country, String state, String city) {
        Haddress haddress = new Haddress();
        haddress.setAddressLine(addressLine);
        haddress.setCity(city);
        haddress.setCountry(country);
        haddress.setState(state);
        haddress.setHId(hid);
        return haddressMapper.insert(haddress);
    }

    @Override
    public int changeHaddress(Long hid, String addressline, String country, String state, String city) {
        QueryWrapper<Haddress> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        Haddress haddress = haddressMapper.selectOne(wrapper);
        haddress.setAddressLine(addressline);
        haddress.setCity(city);
        haddress.setCountry(country);
        haddress.setState(state);
        return haddressMapper.updateById(haddress);
    }
}
