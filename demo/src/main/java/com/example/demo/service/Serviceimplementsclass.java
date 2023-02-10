package com.example.demo.service;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Dtoclass;
import com.example.demo.entity.Entityclass;
import com.example.demo.repository.Repointerface;
import com.example.demo.response.Responseclass;
@Entity
@Service
public class Serviceimplementsclass{
	@Autowired
	Repointerface repo;
	
	public void register(Dtoclass registerDto) {
		
		Entityclass entity = new Entityclass();
		entity.setFirstname(registerDto.getFirstname());
		entity.setLastname(registerDto.getLastname());
		entity.setEmail(registerDto.getEmail());
		entity.setPassword(registerDto.getPassword());
		entity.setAddress(registerDto.getAddress());
		Repointerface.save(entity);
	}
}
