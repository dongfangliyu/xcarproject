package com.fintecher.message.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/12/18
 */
@FeignClient("test-service")
public interface TestClient {
    @RequestMapping("/test")
    void test();
}
