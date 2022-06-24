package com.tools.bys.biz.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tools.bys.biz.generator.domain.TMain;
import com.tools.bys.biz.generator.domain.TSub;

/**
* @author shaunwen
* @description 针对表【t_main】的数据库操作Service
* @createDate 2022-06-22 14:19:55
*/
public interface TMainService extends IService<TMain> {

    Object getMainWithSubAll();


}
