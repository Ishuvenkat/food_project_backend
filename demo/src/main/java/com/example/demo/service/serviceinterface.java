package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.dtoclass;
import com.example.demo.response.responseclass;



public interface serviceinterface {
	responseclass register(dtoclass registerDto); 

}
