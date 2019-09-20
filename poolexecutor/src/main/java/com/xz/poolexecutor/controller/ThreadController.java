package com.xz.poolexecutor.controller;

import com.xz.poolexecutor.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xz小泽
 * @date 2019/9/19 15:05
 **/
@RestController
@RequestMapping(value = "executor")
public class ThreadController {

    @Autowired
    ExecutorService executorService;
    @GetMapping(value = "test")
    public String excutorTest(){
        executorService.executorTask();
        System.out.println("异步非阻塞" );
        return "test";
    }

}
