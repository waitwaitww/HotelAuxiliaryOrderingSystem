package com.code.back.service;

import com.code.back.pojo.Haddress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ??ַ? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface HaddressService extends IService<Haddress> {

    //查询某酒店地址
    Haddress queryHaddressByHid(Long hid);

}
