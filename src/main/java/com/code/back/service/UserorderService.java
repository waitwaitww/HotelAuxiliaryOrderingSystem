package com.code.back.service;

import com.code.back.pojo.Userorder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface UserorderService extends IService<Userorder> {
    //查询某用户所有订单
    List<Userorder> queryAllUserorderByUId(Long uid);

    //查询某用户未支付的订单
    //未支付：0、未出行：1、未评论：2、已评论：3
    List<Userorder> queryAll0OrderById(Long uid);

    //查询某用户未出行的订单
    List<Userorder> queryAll1OrderById(Long uid);

    //查询某用户未评论的订单
    List<Userorder> queryAll2OrderById(Long uid);

    //查询某用户已评论的订单
    List<Userorder> queryAll3OrderById(Long uid);

    //查询某订单
    Userorder queryUserorderById(Long oid);

    //更新订单进度
    int updateUserorderProgress(Long oid);

    //删除订单
    int deleteUserorderById(Long oid);
}
