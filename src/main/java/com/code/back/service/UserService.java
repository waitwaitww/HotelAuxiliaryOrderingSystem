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
    String queryPwdById(Long uid);

    //根据邮箱查找用户密码
    String queryPwdByEmail(String email);

    //根据id查找用户
    User queryUserById(Long uid);

    //更新用户
    int updataUser(User user);

    //更新用户密码
    int updataUpassword(Long uid, String password);

    //删除指定用户
    int deleteUserById(Long uid);

    //解冻指定用户
    int unsealUserById(Long uid);

    //通过邮箱登录
    String sendEmail(String  email);

    //根据邮箱查找用户是否存在
    int isUserExistByEmail(String email);

    //根据id查找用户是否存在
    int isUserExistByUid(Long uid);

    //根据邮箱查找用户
    User queryAllInfoByEmail(String email);

    //添加用户
    int addUser(User user);
}
