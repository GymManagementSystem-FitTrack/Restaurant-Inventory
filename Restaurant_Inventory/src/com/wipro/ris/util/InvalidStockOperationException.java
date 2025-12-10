package com.wipro.ris.util;

public class InvalidStockOperationException extends Exception {
	private static final long serialVersionUID = 1L;
	public InvalidStockOperationException() {
		super("Invalid stock operation exception");
	}
	public InvalidStockOperationException(String message) {
		super(message);
	}

}
