package com.securitas.core;

public class AuthenticationMethodAccessCode implements AuthenticationMethod {

	@Override
	public boolean authenticate(Credential credential) {
		AccessCodeCredential accessCodeCredential = (AccessCodeCredential)credential;
		return accessCodeCredential.getCode().equals("123");
	}

}
