package com.code.back.service.impl;

import com.code.back.pojo.Address;
import com.code.back.mapper.AddressMapper;
import com.code.back.service.AddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

/**
 * <p>
 * ??ַ? 服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-23
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {

}
