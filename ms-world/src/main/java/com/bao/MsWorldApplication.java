package main.java.com.bao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableDiscoveryClient
@SpringBootApplication
public class MsWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsWorldApplication.class, args);
	}
}
