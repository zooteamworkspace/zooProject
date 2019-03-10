package com.zoo.zooApplication.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.zoo.zooApplication.configuration")
public class ZooServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooServiceApplication.class, args);
	}

}
