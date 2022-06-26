package com.code.back.service;

import com.code.back.pojo.Hphoto;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * ͼƬ? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface HphotoService extends IService<Hphoto> {

    //查询某酒店的所有图片
    List<Hphoto> queryAllHphotoByHid(Long hid);

    //查询所有酒店的图片
    List<Hphoto> queryAllHphoto();
}
