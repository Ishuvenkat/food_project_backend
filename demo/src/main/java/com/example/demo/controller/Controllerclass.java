package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dto.Dtoclass;
import com.example.demo.response.Responseclass;
import com.example.demo.service.Serviceinterface;

@RestController
@RequestMapping("/home")
public class Controllerclass {
	
	@Autowired
	Serviceinterface registerService;
	
	
	@PostMapping("/login")
	public Responseclass register(@RequestBody  Dtoclass registerDto) {
		 return registerService.register(registerDto);
	

}
	
	
}