package com.code.back.service.impl;

import com.code.back.pojo.User;
import com.code.back.mapper.UserMapper;
import com.code.back.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ?û?? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("UserServiceImpl")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public String queryPwdById(Long uid){
        return userMapper.queryPasswordByid(uid);
    }

    @Override
    public User queryUserById(Long uid) {
        return userMapper.selectById(uid);
    }

    //更改
    @Override
    public int updataUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public int updataUpassword(Long uid, String password) {
        return userMapper.updateUpassword(uid,password);
    }
}
