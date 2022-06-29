package com.tools.bys.controller;

import com.tools.bys.biz.generator.service.TxTestService;
import com.tools.bys.vo.TxTestDO;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@RestController
@RequestMapping(value = "/single")
public class SingleController {

    @Autowired
    TxTestService service;

    @GetMapping("/getAll")
    public Object getAll(){
        return service.getAllByLimite();
    }

    @GetMapping("/getOne")
    public Object getOne(@NonNull @RequestParam int id){
        return service.getAOneById(id);
    }

    @PostMapping("/insert")
    public Object insertOne(@RequestBody TxTestDO txTestDO){
        return service.insertOne(txTestDO);
    }

    @PostMapping("/update")
    public Object updateOne(@RequestBody TxTestDO txTestDO){
        return service.updateOne(txTestDO);
    }

    @PostMapping("/asy")
    public Callable asy(@RequestBody int id){
        return () -> service.getAOneById(id);
    }
}
