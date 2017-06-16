package com.securitas.core;

public class FingerPrintCredential implements Credential {

	private Object fingerPrint;
	
	public FingerPrintCredential(Object fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	public Object getFingerPrint() {
		return this.fingerPrint;
	}

}
