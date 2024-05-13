package com.Giulia.webServicesMongo.servicos.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(Object id) {
		super("Recurso não encontrado. Id: " + id);
	}
}
