package com.code.back.mapper;

import com.code.back.pojo.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * ??ַ? Mapper 接口
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-23
 */
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}
