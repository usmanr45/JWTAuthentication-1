package com.spring.jwt;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.spring.jwt"})
public class JwtAuthentication1Application {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthentication1Application.class, args);
	}

}
