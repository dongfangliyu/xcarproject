package com.fintecher.sims.config.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: jwdstef
 * @Description: 接受redis消息队列的处理监听
 * @Date 2017/6/9
 */
@Slf4j
@Component
public class Receiver {

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        //System.out.println(roleService.findAll());
        log.info("Received <" + message + ">");
        latch.countDown();
    }
}
