package com.cg.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class SpringBootDataJpaStudCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaStudCourseApplication.class, args);
		
		System.out.println("\nApp started");
	}

}
