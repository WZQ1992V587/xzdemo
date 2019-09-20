package com.example.demo.controller;

import com.xz.xzcommon.constant.XZResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz小泽
 * @date 2019/9/18 10:43
 **/
@RestController
@RequestMapping(value = "test")
public class TestController {

    @GetMapping(value = "getStr")
    public XZResponse testControl(){
        return new XZResponse().setData("dsdsd");
    }
}
