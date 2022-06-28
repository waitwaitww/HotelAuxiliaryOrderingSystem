package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Admin;
import com.code.back.mapper.AdminMapper;
import com.code.back.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ????Ա? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("AdminServiceImpl")
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public String queryAPwdByAid(Long aid) {
        return adminMapper.selectById(aid).getPassword();
    }

    @Override
    public String queryAPwdByAname(String aname) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("aname",aname);
        return adminMapper.selectOne(wrapper).getPassword();
    }
}
