package com.tools.bys.biz.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tools.bys.biz.generator.domain.TxTest;
import com.tools.bys.biz.generator.mapper.TxTestMapper;
import com.tools.bys.biz.generator.service.TxTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author shaunwen
* @description 针对表【tx_test】的数据库操作Service实现
* @createDate 2022-06-20 11:21:21
*/
@Service
@Slf4j
public class TxTestServiceImpl extends ServiceImpl<TxTestMapper, TxTest> implements TxTestService {

    @Override
    public List<TxTest> getAllByLimite() {
        TxTestMapper baseMapper = this.getBaseMapper();
        return baseMapper.selectList(new QueryWrapper<>());
    }
}
