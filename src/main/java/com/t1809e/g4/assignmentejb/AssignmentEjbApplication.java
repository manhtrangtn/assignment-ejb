package com.t1809e.g4.assignmentejb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.t1809e.g4.assignmentejb.*.*")
public class AssignmentEjbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentEjbApplication.class, args);
	}

}