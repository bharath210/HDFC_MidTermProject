package com.hdfc.olms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OfficeLeaveManagementSystemEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeLeaveManagementSystemEmployeeApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
