package com.securitas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.securitas.core.AccessCodeCredential;
import com.securitas.core.Authenticator;
import com.securitas.core.Credential;
import com.securitas.core.FingerPrintCredential;

public class TestAuthentication {

	@Test
	public void testSuccessCodeAuthentication() throws Exception {
		//ARRANGE
		Credential credential = new AccessCodeCredential("123");
		Authenticator authenticator = new Authenticator();
		
		//ACT
		boolean isAuthenticated = authenticator.authenticate(credential);
		
		//ASSERT
		assertTrue(isAuthenticated);
	}

	@Test
	public void testFailureCodeAuthentication() throws Exception {
		//ARRANGE
		Credential credential = new AccessCodeCredential("456");
		Authenticator authenticator = new Authenticator();
		
		//ACT
		boolean isAuthenticated = authenticator.authenticate(credential);
		
		//ASSERT
		assertFalse(isAuthenticated);
	}

	@Test
	public void testSuccessFingerPrintAuthentication() throws Exception {
		//ARRANGE
		Credential credential = new FingerPrintCredential("lkjdbiuasdhfalksdfa7-asdofhuaoasdasd");
		Authenticator authenticator = new Authenticator();
		
		//ACT
		boolean isAuthenticated = authenticator.authenticate(credential);
		
		//ASSERT
		assertTrue(isAuthenticated);
	}

	@Test
	public void testFailureFingerPrintAuthentication() throws Exception {
		//ARRANGE
		Credential credential = new FingerPrintCredential("98rqoiuahfoaiuspodiauds");
		Authenticator authenticator = new Authenticator();
		
		//ACT
		boolean isAuthenticated = authenticator.authenticate(credential);
		
		//ASSERT
		assertFalse(isAuthenticated);
	}
}
