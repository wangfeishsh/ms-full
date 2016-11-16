package com.bao.service.impl;

import com.bao.external.HelloClient;
import com.bao.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baochunyu on 2016/11/15.
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private HelloClient client;

    @Override
    public String service() {
        log.info(client.world());
        return client.world();
    }

    @Override
    @HystrixCommand(fallbackMethod = "hystrixFallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")
        })
    public String hystrix(String str) {
        return client.hystrix();
    }

    private String hystrixFallback(String str) {
        return "world client can't connect";
    }
}
