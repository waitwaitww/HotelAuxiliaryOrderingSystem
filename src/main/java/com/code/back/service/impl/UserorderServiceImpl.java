package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Userorder;
import com.code.back.mapper.UserorderMapper;
import com.code.back.service.UserorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("UserorderServiceImpl")
public class UserorderServiceImpl extends ServiceImpl<UserorderMapper, Userorder> implements UserorderService {

    @Autowired
    private UserorderMapper userorderMapper;

    public UserorderMapper getUserorderMapper() {
        return userorderMapper;
    }

    public void setUserorderMapper(UserorderMapper userorderMapper) {
        this.userorderMapper = userorderMapper;
    }


    @Override
    public List<Userorder> queryAllUserorderByUId(Integer uid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",uid);
        return userorderMapper.selectList(wrapper);
    }

    @Override
    public List<Userorder> queryAll0OrderById(Integer uid) {
        return null;
    }

    @Override
    public List<Userorder> queryAll1OrderById(Integer uid) {
        return null;
    }

    @Override
    public List<Userorder> queryAll2OrderById(Integer uid) {
        return null;
    }

    @Override
    public List<Userorder> queryAll3OrderById(Integer uid) {
        return null;
    }

    @Override
    public Userorder queryUserorderById(Integer oid) {
        return null;
    }

    @Override
    public int updateUserorderProgress(Integer oid) {
        return 0;
    }

    @Override
    public int deleteUserorderById(Integer oid) {
        return 0;
    }
}
