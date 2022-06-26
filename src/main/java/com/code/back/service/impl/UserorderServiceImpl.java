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
    public List<Userorder> queryAllUserorderByUId(Long uid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",uid);
        return userorderMapper.selectList(wrapper);
    }

    @Override
    public List<Userorder> queryAll0OrderById(Long uid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("state",0);
        return userorderMapper.selectList(wrapper);
    }

    @Override
    public List<Userorder> queryAll1OrderById(Long uid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("state",1);
        return userorderMapper.selectList(wrapper);
    }

    @Override
    public List<Userorder> queryAll2OrderById(Long uid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("state",2);
        return userorderMapper.selectList(wrapper);
    }

    @Override
    public List<Userorder> queryAll3OrderById(Long uid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("state",3);
        return userorderMapper.selectList(wrapper);
    }

    @Override
    public Userorder queryUserorderById(Long oid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("o_id",oid);
        return userorderMapper.selectById(wrapper);
    }

    @Override
    public int updateUserorderProgress(Long oid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("o_id",oid);
        Userorder o1 = userorderMapper.selectById(wrapper);
        Integer scurnt = o1.getState();
        o1.setState(scurnt++);
        userorderMapper.updateById(o1);
        return scurnt;
    }

    @Override
    public int deleteUserorderById(Long oid) {
        return userorderMapper.deleteById(oid);
    }
}
