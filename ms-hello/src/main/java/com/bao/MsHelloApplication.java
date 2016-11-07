package com.bao;

import com.bao.external.HelloClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
@SpringBootApplication
public class MsHelloApplication {

    @Autowired
    private HelloClient client;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {
        log.info("hello");
        return "hello" + client.world();
    }

    public static void main(String[] args) {
        SpringApplication.run(MsHelloApplication.class, args);
    }
}
