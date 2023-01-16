package com.cg.rest.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@RequestMapping("/")
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({NoSuchStudentFoundException.class, NoSuchStudentFoundException.class})
	public ErrorInformation handleConflict(Exception ex, HttpServletRequest req) {

		String msg = ex.getMessage();
		String uri = req.getRequestURI();
		System.out.println(msg);
		LocalDateTime dt = LocalDateTime.now();
		ErrorInformation response = new ErrorInformation(uri, msg, dt);

		return response;
	}
}
