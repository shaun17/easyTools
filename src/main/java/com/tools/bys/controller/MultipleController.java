package com.tools.bys.controller;

import com.tools.bys.biz.generator.mapper.TMainMapper;
import com.tools.bys.biz.generator.service.TMainService;
import com.tools.bys.vo.MultipleDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping("/getOne")
    public Object getOne(int id){
        return service.getMainWithSubOne(id);
    }
    @PostMapping("/addOne")
    public Object addOne(@RequestBody MultipleDo multipleDo){
        return service.addMainAndSub(multipleDo);
    }
}
