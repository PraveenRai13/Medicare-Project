package com.simplilearn.medicare.entities;

public class JWTResponse {
String token;

public JWTResponse(String token) {
	super();
	this.token = token;
}
public JWTResponse() {
	
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}

}
