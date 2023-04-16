package com.hdfc.olms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 *@author Bharath Kumar
 *@created 12-Apr-2023
*
 */
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
