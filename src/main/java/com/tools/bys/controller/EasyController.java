package com.tools.bys.controller;

import com.tools.bys.biz.generator.service.TxTestService;
import com.tools.bys.config.GlobalContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/easy")
public class EasyController {

    @Autowired
    TxTestService service;

    @GetMapping("/getAll")
    public Object method(){
        return service.getAllByLimite();
    }

}
