package com.bao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class MsGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGatewayApplication.class, args);
    }
}
