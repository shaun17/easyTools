package com.tools.bys.biz.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tools.bys.biz.generator.domain.TMain;
import com.tools.bys.biz.generator.domain.TSub;
import com.tools.bys.biz.generator.service.TMainService;
import com.tools.bys.biz.generator.mapper.TMainMapper;
import com.tools.bys.biz.generator.service.TSubService;
import com.tools.bys.vo.MultipleDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author shaunwen
* @description 针对表【t_main】的数据库操作Service实现
* @createDate 2022-06-22 14:19:55
*/
@Service
public class TMainServiceImpl extends ServiceImpl<TMainMapper, TMain>
implements TMainService{

    @Autowired
    TSubService tSubService;

    @Override
    public Object getMainWithSubAll() {
        return this.getBaseMapper().getLeftJoinSub();

    }

    @Override
    public Object getMainWithSubOne(int mainId) {
        return this.getBaseMapper().getLeftJoinSubOne(mainId);
    }

    @Override
    @Transactional
    public Object addMainAndSub(MultipleDo multipleDo) {
        TMain build = TMain.builder().column1(multipleDo.getColumn1())
                .column2(multipleDo.getColumn2())
                .column3(multipleDo.getColumn3()).build();
        this.getBaseMapper().insert(build);
        multipleDo.getSubList().stream().forEach(x->x.setMainId(build.getId()));
        tSubService.addSubs(multipleDo.getSubList());
        return this.getMainWithSubOne(build.getId());
    }
}
