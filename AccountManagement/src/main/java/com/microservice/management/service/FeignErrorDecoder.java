package com.microservice.management.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		
		if(response.status()==404 && methodKey.contains("allusers")) {
			return new ResponseStatusException(HttpStatus.valueOf(response.status()),"Users are not found");
		}
		
		if(response.status()==404 && methodKey.contains("finduser")) {
			return new ResponseStatusException(HttpStatus.valueOf(response.status()),"User cannot be found");
		}
		
		return null;
	}

}
