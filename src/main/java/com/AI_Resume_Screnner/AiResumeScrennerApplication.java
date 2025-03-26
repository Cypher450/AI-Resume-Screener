package com.AI_Resume_Screnner;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EntityScan(basePackages = "com.AI_Resume_Screnner.model")
@ComponentScan(basePackages = "com.example.resumescreener") 
public class AiResumeScrennerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiResumeScrennerApplication.class, args);
	}

}
