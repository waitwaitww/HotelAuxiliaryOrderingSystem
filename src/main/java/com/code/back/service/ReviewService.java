package com.code.back.service;

import com.code.back.pojo.Review;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface ReviewService extends IService<Review> {

    //获取某酒店的review对象
    Review queryReviewByHid(Long hid);

    //获取某酒店星级
    float queryRatingByHid(Long hid);

    //获取某酒店评论数
    int qeuryReviewnum(Long hid);
}
