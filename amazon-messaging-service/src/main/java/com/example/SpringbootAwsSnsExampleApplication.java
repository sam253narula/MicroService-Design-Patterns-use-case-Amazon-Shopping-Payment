package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;



/**
 * @author Samarth Narula
 *
 */
@SpringBootApplication(exclude = {
		org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
		org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
		org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class })
@EnableEurekaClient
public class SpringbootAwsSnsExampleApplication {

   
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsSnsExampleApplication.class, args);
    }

}
