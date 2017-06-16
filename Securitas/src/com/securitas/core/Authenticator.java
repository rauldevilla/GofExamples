package com.securitas.core;

import com.securitas.core.factory.AuthenticationMethodFactory;

public class Authenticator {

	public boolean authenticate(Credential credential) throws Exception {
		AuthenticationMethod authenticationMethod = AuthenticationMethodFactory.createAuthenticationMethod(credential);
		return authenticationMethod.authenticate(credential);
	}

}
