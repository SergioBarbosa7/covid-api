package br.com.sergio.api.covid.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.format.DateTimeParseException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(DateTimeParseException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleDateParseException(DateTimeParseException ex) {
		return ResponseEntity.badRequest()
				.body("Formato de data inválido para " + ex.getParsedString() + " Use o formato yyyy-MM-dd");
	}
	
}


