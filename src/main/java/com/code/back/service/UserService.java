package com.code.back.service;

import com.code.back.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ?û?? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface UserService extends IService<User> {

    //根据id查找用户密码
    String queryPwdById(Integer uid);

    //根据id查找用户
    User queryUserById(Integer uid);

    //更新用户
    int updataUser(User user);

    //更新用户密码
    int updataUpassword(Integer uid, String password);
}
