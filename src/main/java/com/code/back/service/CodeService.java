package com.code.back.service;

import com.code.back.pojo.Code;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-28
 */
public interface CodeService extends IService<Code> {

    //存入验证码
    public int addCode(Code code);

    //根据邮箱查找验证码
    String quertyCode(String email);
}
