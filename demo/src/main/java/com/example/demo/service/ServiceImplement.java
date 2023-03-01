package com.example.demo.service;



import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DtoClass;
import com.example.demo.entity.EntityClass;
import com.example.demo.exception.CommonException;
import com.example.demo.repository.Repo;
import com.example.demo.response.ResponseClass;




@Service
public class ServiceImplement implements ServiceInterface{
	
	@Autowired
	Repo repo;


	@Override
	public ResponseClass register(DtoClass registerDto) {
		
		  
		validate(registerDto);
		format(registerDto);

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
	public void validate(DtoClass registerDto) {
		if(registerDto.getEmail() == null || registerDto.getEmail().isEmpty()) {
			throw new CommonException(201, "Email is empty");
		}
		
		if(registerDto.getPassword() == null || registerDto.getPassword().isEmpty()) {
			throw new CommonException(201, "password is empty");
		}
		
		}
	 public void format(DtoClass dtoclass) {
		 String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		 String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

		

			Pattern epattern = Pattern.compile(emailPattern);

			Matcher emailmatcher = epattern.matcher(dtoclass.getEmail());
			if (!emailmatcher.matches()) {
				throw new CommonException(400, "Email is not valid format");

			}

			Pattern ppattern = Pattern.compile(passwordPattern);

			Matcher passwordmatcher = ppattern.matcher(dtoclass.getPassword());
			if (!passwordmatcher.matches()) {
				throw new CommonException(400, "password is not valid format");

			}

	 }
	}

