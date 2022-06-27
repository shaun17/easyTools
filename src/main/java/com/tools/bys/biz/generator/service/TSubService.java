package com.tools.bys.biz.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tools.bys.biz.generator.domain.TSub;
import com.tools.bys.vo.MultipleDo;

import java.util.List;

/**
* @author shaunwen
* @description 针对表【t_sub】的数据库操作Service
* @createDate 2022-06-23 09:40:23
*/
public interface TSubService extends IService<TSub> {
    void addSubs(List<MultipleDo.Sub> list);
}
