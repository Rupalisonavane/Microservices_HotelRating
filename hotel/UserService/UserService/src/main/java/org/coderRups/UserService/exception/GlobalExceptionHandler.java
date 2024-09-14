package org.coderRups.UserService.exception;

import org.coderRups.UserService.payload.ResourceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResourceApi> handlerResourceNotFoundException(ResourceNotFoundException ex){
		String messge=ex.getMessage();
		ResourceApi response=ResourceApi.builder().message(messge).success(true).status(HttpStatus.NOT_FOUND).build();
	 
	    return new ResponseEntity<ResourceApi>(response,HttpStatus.NOT_FOUND);
	}
	
}
