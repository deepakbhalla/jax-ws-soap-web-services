package com.example.demo.ws.rest.healthcheck;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@Value("${java_home}")
	private String javaHome;
	
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Application is running ok. <br><br>JAVA_HOME - " + javaHome;
	}
}
