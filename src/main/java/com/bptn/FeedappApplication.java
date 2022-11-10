package com.bptn;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@EnableAsync
@SpringBootApplication
public class FeedappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedappApplication.class, args);
	}
	
	// Spring executes the method and the method returns a RestTemplate object
	// because of the @Bean annotation. The RestTemplate object is allocated
	// in the Spring IOC container
	
	@Bean
	public Executor taskExecutor() {
	  ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	  executor.setCorePoolSize(2);
	  executor.setMaxPoolSize(2);
	  executor.setQueueCapacity(500);
	  executor.setThreadNamePrefix("FeedAppThread-");
	  executor.initialize();
	  return executor;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	/* 
	 * restemplate is a component in order to send request to our application
	 * We use Bean
	 */

}
