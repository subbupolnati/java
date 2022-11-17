package com.employee_timesheet.exception;

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
public class CustomedEmployeeTimesheetResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@Nullable
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(UserNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleDepartmentNotFoundException(NotFoundException ex, WebRequest request) throws Exception {
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
