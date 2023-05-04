package com.example.springboot.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

	@GetMapping("/hello")
	public String hello(){
		return("Hello Purna");
	}

}
