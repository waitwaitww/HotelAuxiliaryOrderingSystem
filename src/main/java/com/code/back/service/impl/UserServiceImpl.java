package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.User;
import com.code.back.mapper.UserMapper;
import com.code.back.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.back.util.SendEmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
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

    @Autowired
    private SendEmailUtils sendEmailUtils;

    @Autowired
    private static JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private static String from;

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
    public String queryPwdByEmail(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        return userMapper.selectOne(wrapper).getUpassword();
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

    @Override
    public int deleteUserById(Long uid) {
        return userMapper.deleteById(uid);
    }

    @Override
    public int unsealUserById(Long uid) {
        User user = userMapper.selectById(uid);
        user.setDeleted(0);
        return userMapper.updateById(user);
    }

    @Override
    public String sendEmail(String email) {
        String code = sendEmailUtils.sentEmail(email);
        return code;
    }

    @Override
    public int isUserExistByEmail(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        User user = userMapper.selectOne(wrapper);
        if(user!=null) return 1;
        return 0;
    }

    @Override
    public int isUserExistByUid(Long uid) {
        User user = userMapper.selectById(uid);
        if(user!=null) return 1;
        return 0;
    }

    @Override
    public User queryAllInfoByEmail(String email) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public int addUser(User user) {
        if (isUserExistByEmail(user.getEmail()) == 1){
            return 0;
        }
        return userMapper.insert(user);
    }


}
