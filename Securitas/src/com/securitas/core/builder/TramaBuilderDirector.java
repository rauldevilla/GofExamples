package com.securitas.core.builder;

public class TramaBuilderDirector {

	public Trama construct(TramaBuilder builder) {
		Trama trama = new Trama();
		trama.setCredentialType(builder.buildCredentialType());
		trama.setCredential(builder.buildCredential());
		return trama;
	}

}
