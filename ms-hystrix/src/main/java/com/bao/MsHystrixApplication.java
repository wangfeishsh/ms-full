package com.bao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
@Slf4j
//@EnableHystrix
@EnableHystrixDashboard
public class MsHystrixApplication {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {
        log.info("hystrix");
        return "hystrix";
    }

	public static void main(String[] args) {
		SpringApplication.run(MsHystrixApplication.class, args);
	}
}
