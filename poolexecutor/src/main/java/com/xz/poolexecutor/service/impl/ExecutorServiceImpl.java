package com.xz.poolexecutor.service.impl;

import com.xz.poolexecutor.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author xz小泽
 * @date 2019/9/19 15:07
 **/
@Service
public class ExecutorServiceImpl implements ExecutorService{

    @Autowired
    Executor myExecutor;
    @Async(value = "myExecutor")
    @Override


    public void executorTask() {

        System.out.println("1111 = " + 1111);
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("2222 = " + 2222);

       if (myExecutor instanceof ThreadPoolTaskExecutor){
           Future<Object> submit = ((ThreadPoolTaskExecutor) myExecutor).submit(new Callable<Object>() {
               @Override
               public Object call() throws Exception {
                   System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
                   return "sss";
               }
           });
           try {
               Object o = submit.get(1,TimeUnit.SECONDS);
               System.out.println("o = " + o);
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (ExecutionException e) {
               e.printStackTrace();
           } catch (TimeoutException e) {
               e.printStackTrace();
           }
       }

    }


}
