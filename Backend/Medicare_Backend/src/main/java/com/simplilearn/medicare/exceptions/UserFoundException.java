package com.simplilearn.medicare.exceptions;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("User is already existed");
	}
	public UserFoundException(String msg) {super(msg);}
	}

