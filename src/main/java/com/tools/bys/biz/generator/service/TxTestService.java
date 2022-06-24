package com.tools.bys.biz.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tools.bys.biz.generator.domain.TxTest;
import com.tools.bys.vo.TxTestDO;

import java.util.List;

/**
* @author shaunwen
* @description 针对表【tx_test】的数据库操作Service
* @createDate 2022-06-20 11:21:21
*/
public interface TxTestService extends IService<TxTest> {

     List<TxTest> getAllByLimite();

     TxTest getAOneById(int id);

     TxTest insertOne(TxTestDO txTestDO);

}
