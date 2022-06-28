package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Hcheck;
import com.code.back.mapper.HcheckMapper;
import com.code.back.service.HcheckService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ??ס? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("HcheckServiceImpl")
public class HcheckServiceImpl extends ServiceImpl<HcheckMapper, Hcheck> implements HcheckService {


    @Autowired
    private HcheckMapper hcheckMapper;

    public HcheckMapper getHcheckMapper() {
        return hcheckMapper;
    }

    public void setHcheckMapper(HcheckMapper hcheckMapper) {
        this.hcheckMapper = hcheckMapper;
    }

    @Override
    public Hcheck queryHcheckByHid(Long hid) {
        QueryWrapper<Hcheck> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        return hcheckMapper.selectOne(wrapper);
    }

    @Override
    public int updateHcheck(Hcheck hcheck) {
        return hcheckMapper.updateById(hcheck);
    }
}
