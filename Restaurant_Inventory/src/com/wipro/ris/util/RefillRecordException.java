package com.wipro.ris.util;

public class RefillRecordException extends Exception {
	private static final long serialVersionUID = 1L;
	public RefillRecordException() {
		super("Invalid refill record exception");
	}
	public RefillRecordException(String message) {
		super(message);
	}

}
