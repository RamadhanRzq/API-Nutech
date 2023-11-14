package com.nutech.api.exception;

public class UserAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 501735311336090223L;
	public UserAlreadyExistsException(String user) {
		super("User "+user+" already exists");
	}
}
