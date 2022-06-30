package com.code.back.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.Vo.UserorderVo;
import com.code.back.mapper.UserorderVoMapper;
import com.code.back.pojo.Userorder;
import com.code.back.mapper.UserorderMapper;
import com.code.back.service.UserorderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("UserorderServiceImpl")
public class UserorderServiceImpl extends ServiceImpl<UserorderMapper, Userorder> implements UserorderService {

    @Autowired
    private UserorderMapper userorderMapper;

    @Autowired
    private UserorderVoMapper userorderVoMapper;

    public UserorderMapper getUserorderMapper() {
        return userorderMapper;
    }

    public void setUserorderMapper(UserorderMapper userorderMapper) {
        this.userorderMapper = userorderMapper;
    }


    @Override
    public List<UserorderVo> queryAllUserorderByUId(Long uid) {
        return userorderVoMapper.queryAllOrderByUid(uid);
    }

    @Override
    public List<UserorderVo> queryAllStateOrderById(Long uid,int state) {
        return userorderVoMapper.queryAllStateOrderById(uid,state);
    }

    @Override
    public int updateSuccessPay(Long oid, Date payTime,String alipayNo) {
        Userorder userorder = userorderMapper.selectById(oid);
        userorder.setPayTime(payTime);
        userorder.setState(1);
        userorder.setAlipayNo(alipayNo);
        return userorderMapper.updateById(userorder);
    }


    @Override
    public UserorderVo queryUserorderById(Long oid) {
        return userorderVoMapper.queryUserorderByOid(oid);
    }

    @Override
    public int updateUserorderProgress(Long oid) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("o_id",oid);
        Userorder o1 = userorderMapper.selectById(wrapper);
        Integer scurnt = o1.getState();
        o1.setState(scurnt++);
        userorderMapper.updateById(o1);
        return scurnt;
    }

    @Override
    public int addUserorder(Userorder userorder) {
        return userorderMapper.insert(userorder);
    }

    @Override
    public int deleteUserorderById(Long oid) {
        return userorderMapper.deleteById(oid);
    }

    @Override
    public List<String> queryAllReviewByHid(Long hid) {
        return userorderMapper.selectAllReviewByHid(hid);
    }

    @Override
    public int updateCheckInOrder(Long oid) {
        Userorder userorder = userorderMapper.selectById(oid);
        String now = DateUtil.now();
        userorder.setCheckinTime(DateUtil.parseDateTime(now));
        userorder.setState(2);
        return userorderMapper.updateById(userorder);
    }

    @Override
    public int updateCheckOutOrder(Long oid) {
        Userorder userorder = userorderMapper.selectById(oid);
        String now = DateUtil.now();
        userorder.setCheckoutTime(DateUtil.parseDateTime(now));
        userorder.setState(3);
        return userorderMapper.updateById(userorder);
    }

    @Override
    public int comment(Long oid, float rating, String review) {
        Userorder userorder = userorderMapper.selectById(oid);
        userorder.setRating(rating);
        userorder.setReview(review);
        return userorderMapper.updateById(userorder);
    }

    @Override
    public Userorder quserOrederByOid(Long oid) {
        return userorderMapper.selectById(oid);
    }

    @Override
    public Userorder queryOrderByAlipayNo(String alipayNo) {
        QueryWrapper<Userorder> wrapper = new QueryWrapper<>();
        wrapper.eq("alipay_no",alipayNo);
        return userorderMapper.selectOne(wrapper);
    }

}
