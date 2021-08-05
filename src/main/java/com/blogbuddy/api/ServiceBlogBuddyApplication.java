package com.blogbuddy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableHystrix
@EnableSwagger2
@SpringBootApplication
public class ServiceBlogBuddyApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceBlogBuddyApplication.class, args);
	}
}
