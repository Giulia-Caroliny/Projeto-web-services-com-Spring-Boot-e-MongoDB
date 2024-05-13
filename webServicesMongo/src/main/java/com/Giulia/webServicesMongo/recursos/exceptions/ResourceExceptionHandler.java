package com.Giulia.webServicesMongo.recursos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Giulia.webServicesMongo.servicos.exceptions.DatabaseException;
import com.Giulia.webServicesMongo.servicos.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String error = "Recurso não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		String error = "Erro no banco de dados.";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError erro = new StandardError(System.currentTimeMillis(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
