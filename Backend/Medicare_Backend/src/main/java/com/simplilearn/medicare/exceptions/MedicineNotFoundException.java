package com.simplilearn.medicare.exceptions;

public class MedicineNotFoundException extends Exception{
	public MedicineNotFoundException() {
		super("Medicine Not found");
	}
	
	
public MedicineNotFoundException(String msg) {super(msg);}
}
	



