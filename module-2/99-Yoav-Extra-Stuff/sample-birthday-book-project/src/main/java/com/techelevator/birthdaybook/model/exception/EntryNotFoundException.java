package com.techelevator.birthdaybook.model.exception;

public class EntryNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EntryNotFoundException() {
		super("Birthday Entry not found");
	}

}
