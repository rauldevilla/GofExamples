package com.securitas.core;

public class AuthenticationMethodFingerPrint implements AuthenticationMethod {

	@Override
	public boolean authenticate(Credential credential) {
		FingerPrintCredential fingerPrintCredential = (FingerPrintCredential)credential;
		return fingerPrintCredential.getFingerPrint().equals("lkjdbiuasdhfalksdfa7-asdofhuaoasdasd");
	}

}
