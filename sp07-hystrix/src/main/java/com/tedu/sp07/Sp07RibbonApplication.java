package com.tedu.sp07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/*@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication*/
@SpringCloudApplication
public class Sp07RibbonApplication {

	//创建 RestTemplate 实例，并存入 spring 容器
	@Bean
	@LoadBalanced//负载均衡注解
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
		f.setConnectTimeout(1000);
		f.setReadTimeout(1000);
		return new RestTemplate(f);
	}
	public static void main(String[] args) {
		SpringApplication.run(Sp07RibbonApplication.class, args);
	}
	
}	
