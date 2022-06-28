package com.code.back.service;

import com.code.back.pojo.Roomtype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * ????? 服务类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
public interface RoomtypeService extends IService<Roomtype> {
    //展示某酒店的所有房型
    List<Roomtype> queryAllRoomtypeByHid(Long hid);

    //查询所有房型信息
    List<Roomtype> queryAllRoomtype();

    //根据入住人数搜索当前酒店的房型
    List<Roomtype> queryRoomtypeByHidAndPnum(Long hid,int pnum);

    //根据入住人数搜索所有酒店的房型
    List<Roomtype> queryRoomtypeByPnum(int pnum);

    //根据rid删除房型
    int deleteRoomtypeByRid(Long rid);

    //查询某一房型信息
    Roomtype queryRoomtype(Long rid);

    //某房型数量减一
    int reduceRoomtypeByRid(Long rid);

    //某房型数量加一
    int increaseRoomtypeByRid(Long rid);


}
