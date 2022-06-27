package com.tools.bys.biz.generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tools.bys.biz.generator.domain.TMain;
import com.tools.bys.biz.generator.domain.TSub;

import java.util.List;

/**
* @author shaunwen
* @description 针对表【t_main】的数据库操作Mapper
* @createDate 2022-06-22 14:19:55
* @Entity com.tools.bys.biz.generator.domain.TMain
*/
public interface TMainMapper extends BaseMapper<TMain> {

    List<TMain> getLeftJoinSub();

    List<TMain> getLeftJoinSubOne(int id);
}
