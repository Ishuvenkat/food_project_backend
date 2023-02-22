package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DtoClass;
import com.example.demo.entity.EntityClass;
import com.example.demo.repository.repo;
import com.example.demo.response.responseclass;

@Service

public class ServiceImplement implements ServiceInterface {
	
	@Autowired
	repo repo;
	
	
	@Override
	public responseclass register(DtoClass registerDto)
	{
		EntityClass entity = new EntityClass();
		entity.setFirstname(registerDto.getFirstname());
		entity.setLastname(registerDto.getLastname());
		entity.setEmail(registerDto.getEmail());
		entity.setPassword(registerDto.getPassword());
		entity.setAddress(registerDto.getAddress());
		repo.save(entity);
		
		
		
		
	responseclass responseclass= new responseclass();
	responseclass.setStatus(200);
	responseclass.setMessage("data saved successfully to DB");
	
		return responseclass;
		
	}

}
