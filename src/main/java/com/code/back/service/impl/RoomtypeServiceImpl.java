package com.code.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.back.pojo.Roomtype;
import com.code.back.mapper.RoomtypeMapper;
import com.code.back.service.RoomtypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ????? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-25
 */
@Service
public class RoomtypeServiceImpl extends ServiceImpl<RoomtypeMapper, Roomtype> implements RoomtypeService {

    @Autowired
    private RoomtypeMapper roomtypeMapper;

    public RoomtypeMapper getRoomtypeMapper() {
        return roomtypeMapper;
    }

    public void setRoomtypeMapper(RoomtypeMapper roomtypeMapper) {
        this.roomtypeMapper = roomtypeMapper;
    }

    @Override
    public List<Roomtype> queryAllRoomtypeByHid(Long hid) {
        QueryWrapper<Roomtype> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        return roomtypeMapper.selectList(wrapper);
    }

    @Override
    public List<Roomtype> queryAllRoomtype() {
        return roomtypeMapper.selectList(null);
    }

    @Override
    public List<Roomtype> queryRoomtypeByHidAndPnum(Long hid, int pnum) {
        QueryWrapper<Roomtype> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id",hid);
        wrapper.eq("pnum",pnum);
        return roomtypeMapper.selectList(wrapper);
    }

    @Override
    public List<Roomtype> queryRoomtypeByPnum(int pnum) {
        QueryWrapper<Roomtype> wrapper = new QueryWrapper<>();
        wrapper.eq("pnum",pnum);
        return roomtypeMapper.selectList(wrapper);
    }

    @Override
    public int deleteRoomtypeByRid(Long rid) {
        return roomtypeMapper.deleteById(rid);
    }

    @Override
    public Roomtype queryRoomtype(Long rid) {
        return roomtypeMapper.selectById(rid);
    }

    @Override
    public int reduceRoomtypeByRid(Long rid) {
        QueryWrapper<Object> wrapper = new QueryWrapper<>();
        Roomtype room=roomtypeMapper.selectById(rid);
        room.setSurplusroomnum(room.getSurplusroomnum() -1 );
        return roomtypeMapper.updateById(room);
    }

    @Override
    public int increaseRoomtypeByRid(Long rid) {
        QueryWrapper<Object> wrapper = new QueryWrapper<>();
        Roomtype room=roomtypeMapper.selectById(rid);
        room.setSurplusroomnum(room.getSurplusroomnum() +1 );
        return roomtypeMapper.updateById(room);
    }
}
