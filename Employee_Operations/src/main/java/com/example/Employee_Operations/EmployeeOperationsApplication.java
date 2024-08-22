package com.example.Employee_Operations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EmployeeOperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeOperationsApplication.class, args);
		log.info("Application has started!");
	}

}
