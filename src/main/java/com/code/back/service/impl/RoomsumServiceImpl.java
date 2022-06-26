package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Roomsum;
import com.code.back.mapper.RoomsumMapper;
import com.code.back.service.RoomsumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ????ͳ??? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
public class RoomsumServiceImpl extends ServiceImpl<RoomsumMapper, Roomsum> implements RoomsumService {

    @Autowired
    private RoomsumMapper roomsumMapper;

    public RoomsumMapper getRoomsumMapper() {
        return roomsumMapper;
    }

    public void setRoomsumMapper(RoomsumMapper roomsumMapper) {
        this.roomsumMapper = roomsumMapper;
    }

    @Override
    public int queryRoomsum(Long roomsum_id) {
        return roomsumMapper.selectById(roomsum_id).getRoomnum();
    }

    @Override
    public int queryRoomsumByHid(Long hid) {
        QueryWrapper<Roomsum> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        return roomsumMapper.selectOne(wrapper).getRoomnum();
    }

    @Override
    public int reduceRoomsum(Long roomsum_id) {
        Roomsum roomsum = roomsumMapper.selectById(roomsum_id);
        roomsum.setRoomnum(roomsum.getRoomnum()-1);
        return roomsumMapper.updateById(roomsum);
    }

    @Override
    public int reduceRoomsumByHid(Long hid) {
        QueryWrapper<Roomsum> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        Roomsum roomsum = roomsumMapper.selectOne(wrapper);
        roomsum.setRoomnum(roomsum.getRoomnum()-1);
        return roomsumMapper.updateById(roomsum);
    }

    @Override
    public int increaseRoomsum(Long roomsum_id) {
        Roomsum roomsum = roomsumMapper.selectById(roomsum_id);
        roomsum.setRoomnum(roomsum.getRoomnum()+1);
        return roomsumMapper.updateById(roomsum);
    }

    @Override
    public int increaseRoomsumByHid(Long hid) {
        QueryWrapper<Roomsum> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        Roomsum roomsum = roomsumMapper.selectOne(wrapper);
        roomsum.setRoomnum(roomsum.getRoomnum()+1);
        return roomsumMapper.updateById(roomsum);
    }
}
