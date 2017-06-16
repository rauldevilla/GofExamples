package com.securitas.core.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.securitas.core.AuthenticationMethod;
import com.securitas.core.Credential;

public class AuthenticationMethodFactory {

	private static Properties configuration;
	
	static {
		configuration = new  Properties();
		InputStream in = AuthenticationMethodFactory.class.getResourceAsStream("/AuthenticationFactory.properties");
		if (in == null) {
			throw new RuntimeException("AuthenticationFactory.properties not found");
		}
		
		try {
			configuration.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String getImplClassName(Credential credential) {
		return configuration.getProperty(credential.getClass().getName());
	}
	
	private static Object instantiate(String className) throws Exception {
		return Class.forName(className).newInstance();
	}
	
	public static AuthenticationMethod createAuthenticationMethod(Credential credential) throws Exception {
		String authenticatorClassName = getImplClassName(credential);
		if (authenticatorClassName == null) {
			return null;
		}
		AuthenticationMethod authenticationMethod = (AuthenticationMethod)instantiate(authenticatorClassName);
		return authenticationMethod;
	}
	
}
