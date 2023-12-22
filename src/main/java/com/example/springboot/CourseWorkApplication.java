package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.springboot","com.example.springboot.controller","com.example.springboot.entity","com.example.springboot.entityVO","com.example.springboot.repository","com.example.springboot.service","com.example.springboot.service.impl"})
@EntityScan(basePackages = {"com.example.springboot.entity"})
@EnableJpaRepositories(basePackages = {"com.example.springboot"})
public class CourseWorkApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(CourseWorkApplication.class, args);
		System.out.println("Hello world!");
	}
}