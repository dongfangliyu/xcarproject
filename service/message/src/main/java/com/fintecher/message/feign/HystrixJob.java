package com.fintecher.message.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/12/18
 */
@Component
//开启定时任务
@EnableScheduling
public class HystrixJob {
    @Autowired
    private TestClient testClient;
    @Scheduled(cron = "0/20 * * * * ?")
    public void doJob(){
        try{
            testClient.test();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
