package com.code.back.service;

import com.code.back.Vo.UserorderVo;
import com.code.back.pojo.Userorder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
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
    List<UserorderVo> queryAllUserorderByUId(Long uid);

    //查询某用户未支付的订单
    //未支付：0、未出行：1、未评论：2、已评论：3
    List<UserorderVo> queryAllStateOrderById(Long uid,int state);

    //完成支付的订单信息修改
    int updateSuccessPay(Long oid, Date payTime);


    //查询某订单
    UserorderVo queryUserorderById(Long oid);

    //更新订单进度
    int updateUserorderProgress(Long oid);

    //增加订单
    int addUserorder(Userorder userorder);

    //删除订单
    int deleteUserorderById(Long oid);

    //查询某酒店的所有评论
    List<String> queryAllReviewByHid(Long hid);
}
