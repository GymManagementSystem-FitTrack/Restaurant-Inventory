package com.wipro.ris.util;

public class IngredientNotFoundException  extends Exception{
	private static final long serialVersionUID = 1L;
	public IngredientNotFoundException() {
		super("Invalid ingredient not found exception");
	}
	public IngredientNotFoundException(String message) {
		super(message);
	}

}
