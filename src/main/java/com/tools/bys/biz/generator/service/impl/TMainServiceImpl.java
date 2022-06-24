package com.tools.bys.biz.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tools.bys.biz.generator.domain.TMain;
import com.tools.bys.biz.generator.service.TMainService;
import com.tools.bys.biz.generator.mapper.TMainMapper;
import com.tools.bys.biz.generator.service.TSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author shaunwen
* @description 针对表【t_main】的数据库操作Service实现
* @createDate 2022-06-22 14:19:55
*/
@Service
public class TMainServiceImpl extends ServiceImpl<TMainMapper, TMain>
implements TMainService{

    @Autowired
    TSubService subService;


    @Override
    public Object getMainWithSubAll() {
        QueryWrapper queryWrapper = new QueryWrapper();
        return null;
    }
}
