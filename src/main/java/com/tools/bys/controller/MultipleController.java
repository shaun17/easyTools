package com.tools.bys.controller;

import com.tools.bys.biz.generator.mapper.TMainMapper;
import com.tools.bys.biz.generator.service.TMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/multiple")
public class MultipleController {

    @Autowired
    TMainService service;

    @GetMapping("/getAll")
    public Object getAll(){
        return service.getMainWithSubAll();
    }
}
