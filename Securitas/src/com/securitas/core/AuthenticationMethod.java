package com.securitas.core;

public interface AuthenticationMethod {
	public boolean authenticate(Credential credential);
}
