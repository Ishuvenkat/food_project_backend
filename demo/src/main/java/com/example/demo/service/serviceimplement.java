package com.example.demo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DtoClass;
import com.example.demo.entity.EntityClass;
import com.example.demo.exceptio.commonException;
import com.example.demo.repository.Repo;
import com.example.demo.response.ResponseClass;

@Service

public class ServiceImplement implements ServiceInterface {

	@Autowired
	Repo Repo;

	@Override
	public ResponseClass register(DtoClass registerDto) {

		validate(registerDto);
		format(registerDto);
		EntityClass entity = new EntityClass();
		entity.setFirstname(registerDto.getFirstname());
		entity.setLastname(registerDto.getLastname());
		entity.setEmail(registerDto.getEmail());
		entity.setPassword(registerDto.getPassword());
		entity.setAddress(registerDto.getAddress());
		Repo.save(entity);

		ResponseClass ResponseClass = new ResponseClass();
		ResponseClass.setStatus(200);
		ResponseClass.setMessage("data saved successfully to DB");

		return ResponseClass;

	}

	public void validate(DtoClass registerDto) {
		if (registerDto.getEmail() == null || registerDto.getEmail().isEmpty()) {
			throw new commonException(200, "Email is Empty");
		}
		if (registerDto.getPassword() == null || registerDto.getPassword().isEmpty()
				|| registerDto.getPassword().isBlank()) {
			throw new commonException(200, "password is Empty");
		}
		if (registerDto.getFirstname().isEmpty() || registerDto.getFirstname() == null) {
			throw new commonException(200, "Firstname is Empty");
		}
		if (registerDto.getLastname() == null || registerDto.getLastname().isEmpty()) {
			throw new commonException(200, "lastname is Empty");
		}
		if (registerDto.getAddress() == null || registerDto.getAddress().isEmpty()) {
			throw new commonException(200, "Address is Empty");
		}

	}

	public void format(DtoClass dtoClass) {
		String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

		String passwordPattern = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{8,10})";

		String namepattern = "^[A-Za-z]\\w{5, 29}$";

		Pattern epattern = Pattern.compile(emailPattern);

		Matcher emailmatcher = epattern.matcher(dtoClass.getEmail());
		if (!emailmatcher.matches()) {
			throw new commonException(1400, "Email is not valid format");

		}

		Pattern ppattern = Pattern.compile(passwordPattern);

		Matcher passwordmatcher = epattern.matcher(dtoClass.getPassword());
		if (!passwordmatcher.matches()) {
			throw new commonException(1400, "password is not valid format");

		}

		Pattern npattern = Pattern.compile(namepattern);

		Matcher firstnamematcher = npattern.matcher(dtoClass.getFirstname());
		if (!firstnamematcher.matches()) {
			throw new commonException(1400, "firstname is not valid format");

		}

		Matcher lastnamematcher = npattern.matcher(dtoClass.getLastname());
		if (!lastnamematcher.matches()) {
			throw new commonException(1400, "lastname is not valid format");

		}

	}

}
