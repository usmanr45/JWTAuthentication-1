package com.spring.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@RequestMapping("/helloWorld")
	public String firstRequest(){
		return "hello world";
		
	}
	
}
