package com.code.back.service;

import com.code.back.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ????Ա? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface AdminService extends IService<Admin> {

    //根据管理员id查找密码
    String queryAPwdByAid(Long aid);

    //根据管理员name查询密码
    String queryAPwdByAname(String aname);
}
