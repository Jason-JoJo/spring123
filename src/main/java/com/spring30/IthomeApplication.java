package com.spring30;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@ComponentScan(basePackages  = {"com.spring30.*, com.spring30.service, com.spring30.dao, com.spring30.model, com.spring30.dao.MemberRepository"})
//@ComponentScan(basePackages = {"com.spring30.*"})
@SpringBootApplication(scanBasePackages="com.spring30")
public class IthomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(IthomeApplication.class, args);
	}

}
