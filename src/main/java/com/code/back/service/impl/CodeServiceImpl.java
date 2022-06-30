package com.code.back.service.impl;

import com.code.back.pojo.Code;
import com.code.back.mapper.CodeMapper;
import com.code.back.service.CodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨锋
 * @since 2022-06-28
 */
@Service
@Qualifier("CodeServiceImpl")
public class CodeServiceImpl extends ServiceImpl<CodeMapper, Code> implements CodeService {

    @Autowired
    CodeMapper codeMapper;
    @Override
    public int addCode(Code code) {
        return codeMapper.insert(code);
    }

    @Override
    public String quertyCode(String email) {
        return codeMapper.selectById(email).getCode();
    }
}
