package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Review;
import com.code.back.mapper.ReviewMapper;
import com.code.back.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ????? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
@Qualifier("ReviewServiceImpl")
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public Review queryReviewByHid(Long hid) {
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id", hid);
        return reviewMapper.selectOne(wrapper);
    }

    @Override
    public float queryRatingByHid(Long hid) {
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id", hid);
        return reviewMapper.selectOne(wrapper).getRatingAvg();
    }

    @Override
    public int qeuryReviewnum(Long hid) {
        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id", hid);
        return reviewMapper.selectOne(wrapper).getNumberOfReview();
    }

    @Override
    public int addnumber(Long hId,float rating) {
        Review review = queryReviewByHid(hId);
        float ra = (review.getRatingAvg()*review.getNumberOfReview()+rating);
        review.setNumberOfReview(review.getNumberOfReview()+1);
        return 0;
    }
}
