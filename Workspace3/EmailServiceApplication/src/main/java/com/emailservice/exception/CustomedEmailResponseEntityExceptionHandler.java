package com.emailservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomedEmailResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@Nullable
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(EmailNotSentException.class)
	public final ResponseEntity<Object> handleEmailNotSentExceptionn(EmailNotSentException ex, WebRequest request) throws Exception {
		ExceptionResponse er=new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(er,HttpStatus.NOT_FOUND);
	}
}
