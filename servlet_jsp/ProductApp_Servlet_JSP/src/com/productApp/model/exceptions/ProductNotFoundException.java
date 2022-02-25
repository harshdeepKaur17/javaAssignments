package com.productApp.model.exceptions;

public class ProductNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 5869289220781395308L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}