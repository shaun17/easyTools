package com.tools.bys.biz.generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tools.bys.biz.generator.domain.TSub;
import com.tools.bys.biz.generator.mapper.TSubMapper;
import com.tools.bys.biz.generator.service.TSubService;
import com.tools.bys.vo.MultipleDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author shaunwen
* @description 针对表【t_sub】的数据库操作Service实现
* @createDate 2022-06-22 14:21:40
*/
@Service
public class TSubServiceImpl extends ServiceImpl<TSubMapper, TSub>
implements TSubService {

    @Override
    public void addSubs(List<MultipleDo.Sub> list) {
        List adds = new ArrayList();
        list.stream().forEach(x ->{
            TSub build = TSub.builder().column1(x.getColumn1())
                    .mainId(x.getMainId())
                    .column2(x.getColumn2())
                    .column3(x.getColumn3()).build();
            adds.add(build);
        });
        this.saveBatch(adds);
    }


}
