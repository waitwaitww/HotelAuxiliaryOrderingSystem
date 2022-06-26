package com.code.back.service;

import com.code.back.pojo.Hcheck;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ??ס? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface HcheckService extends IService<Hcheck> {

    //查询某酒店签到签退时间
    Hcheck queryHcheckByHid(Long hid);

    //跟新某酒店签到签退时间
    int updateHcheck(Hcheck hcheck);
}
