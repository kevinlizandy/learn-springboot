package com.vika.learn.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<?> resourceNotFoundException exx, WebRequest request) {
//		ErrorDetails errorDetails = new ErrorDetails(new Date(),  exx.getMessage(), request.getDescription(false));
//		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//	}
}
