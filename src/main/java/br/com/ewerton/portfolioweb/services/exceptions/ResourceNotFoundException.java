package br.com.ewerton.portfolioweb.services.exceptions;

public class ResourceNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("não localizamos um usuário com a id");
	}

}
