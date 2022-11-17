package com.sample.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomedEmployeeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@Nullable
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),"validation failed",ex.getBindingResult().toString());
		return new ResponseEntity<Object>(er,HttpStatus.BAD_REQUEST);
	}
}
