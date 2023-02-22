 

package com.example.demo.service;

import com.example.demo.dto.DtoClass;
import com.example.demo.response.ResponseClass;

public interface ServiceInterface {
	
	ResponseClass register(DtoClass registerDto);

}
