package com.code.back.service.impl;

import com.code.back.pojo.User;
import com.code.back.mapper.UserMapper;
import com.code.back.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ?û?? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
