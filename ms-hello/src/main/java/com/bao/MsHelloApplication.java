package com.bao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class MsHelloApplication {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String get() {
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(MsHelloApplication.class, args);
	}
}
