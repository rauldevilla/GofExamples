package com.securitas.core.builder;

import com.securitas.core.AccessCodeCredential;
import com.securitas.core.Credential;

public class TramaBuilder {

	private String rawTrama;
	private CredentialType credentialType;
	private Object credentialValue;
	
	public TramaBuilder(String rawTrama) {
		this.rawTrama = rawTrama;
		compile();
	}
	
	private void compile() {
		this.credentialType = CredentialType.ACCESS_CODE;
		this.credentialValue = "123";
	}
	
	public Credential buildCredential() {
		if (this.credentialType == CredentialType.ACCESS_CODE) {
			return new AccessCodeCredential(this.credentialValue.toString());
		}
		
		return null;
	}

	public CredentialType buildCredentialType() {
		return null;
	}

}
