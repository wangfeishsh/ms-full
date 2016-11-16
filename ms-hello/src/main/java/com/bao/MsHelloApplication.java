package com.bao;

import com.bao.external.HelloClient;
import com.bao.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class MsHelloApplication {

    @Autowired
    private HelloClient client;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {
        log.info("hello");
        return "hello" + client.world();
    }

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String world() {
        return testService.service();
    }

    @RequestMapping(value = "/hystrix", method = RequestMethod.GET)
    public String hystrix() {
        return testService.hystrix("hystrix");
    }

    public static void main(String[] args) {
        SpringApplication.run(MsHelloApplication.class, args);
    }
}
