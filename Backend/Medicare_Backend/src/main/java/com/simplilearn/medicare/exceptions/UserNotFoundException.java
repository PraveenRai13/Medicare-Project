package com.simplilearn.medicare.exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException() {
	super("User is not available in databases");
}
public UserNotFoundException(String msg) {super(msg);}
}