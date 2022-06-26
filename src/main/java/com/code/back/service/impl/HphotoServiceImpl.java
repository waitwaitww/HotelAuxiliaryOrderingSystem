package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Hphoto;
import com.code.back.mapper.HphotoMapper;
import com.code.back.service.HphotoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ͼƬ? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
public class HphotoServiceImpl extends ServiceImpl<HphotoMapper, Hphoto> implements HphotoService {

    @Autowired
    private HphotoMapper hphotoMapper;

    @Override
    public List<Hphoto> queryAllHphotoByHid(Long hid) {
        QueryWrapper<Hphoto> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        return hphotoMapper.selectList(wrapper);
    }

    @Override
    public List<Hphoto> queryAllHphoto() {
        return hphotoMapper.selectList(null);
    }
}
