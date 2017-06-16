package com.securitas.core;

public class AccessCodeCredential implements Credential {

	private String code;
	
	public AccessCodeCredential(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
