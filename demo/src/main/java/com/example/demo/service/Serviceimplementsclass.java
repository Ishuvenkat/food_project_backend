package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DtoClass;
import com.example.demo.entity.EntityClass;
import com.example.demo.repository.RepoClass;
import com.example.demo.response.ResponseClass;


@Service
public class ServiceImplementsClass implements ServiceInterface{
	
	@Autowired
	RepoClass repo;


	@Override
	public ResponseClass register(DtoClass registerDto) {

		EntityClass entity = repo.findByEmail(registerDto.getEmail());
		ResponseClass responseclass= new ResponseClass();

		if(entity.getPassword().equals(registerDto.getPassword())) {
			responseclass.setMessage("login successful");
			responseclass.setStatus(200);
		}
		else {
			responseclass.setMessage("password doesn't match");
			responseclass.setStatus(202);

		}


		return responseclass;


	}
}
