package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.dtoclass;
import com.example.demo.response.responseclass;
import com.example.demo.service.*;

@RestController
@RequestMapping("/home")

public class controllerclass {
	
	@Autowired
	serviceinterface registerService;
	
	
	@PostMapping("/register")
	public responseclass register(@RequestBody  dtoclass registerDto) {
		 return registerService.register(registerDto);
	}
	

}
