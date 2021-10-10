package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Samarth Narula
 *
 */

@SpringBootApplication
@EnableEurekaServer
public class AmazonServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonServerApplication.class, args);
	}

}
