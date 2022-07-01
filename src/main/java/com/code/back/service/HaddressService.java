package com.code.back.service;

import cn.hutool.db.DaoTemplate;
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

    //添加酒店地址
    int addHaddress(Long hid,String addressLine, String country, String state,String city);

    int changeHaddress(Long hid, String addressline, String country, String state, String city);
}
