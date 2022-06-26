package com.code.back.service;

import com.code.back.pojo.Roomsum;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * ????ͳ??? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface RoomsumService extends IService<Roomsum> {

    //返回指定酒店房间剩余数量
    int queryRoomsum(Long roomsum_id);

    //返回某酒店所有房间数量
    int queryRoomsumByHid(Long hid);

    //某酒店房间数量减一
    int reduceRoomsum(Long roomsum_id);

    //某指定酒店房间数量减一
    int reduceRoomsumByHid(Long hid);

    //某酒店房间数量加一
    int increaseRoomsum(Long roomsum_id);

    //某指定酒店房间数量加一
    int increaseRoomsumByHid(Long hid);

}
