package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.dtoclass;
import com.example.demo.entity.entityclass;
import com.example.demo.repository.repo;
import com.example.demo.response.responseclass;

@Service

public class serviceimplement  {
	
	@Autowired
	repo repo;
	
	
	
	public void register(dtoclass registerDto)
	{
		entityclass entity = new entityclass();
		entity.setFirstname(registerDto.getFirstname());
		entity.setLastname(registerDto.getLastname());
		entity.setEmail(registerDto.getEmail());
		entity.setPassword(registerDto.getPassword());
		entity.setAddress(registerDto.getAddress());
		repo.save(entity);
		
	}

}
