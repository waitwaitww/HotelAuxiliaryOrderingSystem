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
    //未支付：0、未入住：1、已入住：2、完成入住：3
    List<UserorderVo> queryAllStateOrderById(Long uid,int state);

    //完成支付的订单信息修改
    int updateSuccessPay(String oid, Date payTime,String alipayNo);


    //查询某订单
    UserorderVo queryUserorderById(String oid);

    //更新订单进度
    int updateUserorderProgress(String oid);

    //增加订单
    int addUserorder(Userorder userorder);

    //删除订单
    int deleteUserorderById(String oid);

    //查询某酒店的所有评论
    List<String> queryAllReviewByHid(Long hid);

    int updateCheckInOrder(String oid);

    int updateCheckOutOrder(String oid);

    int comment(String oid, float rating, String review);

    Userorder quserOrederByOid(String oid);

    //通过alipayno查找订单
    Userorder queryOrderByAlipayNo(String alipayNo);
}
