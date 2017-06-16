package com.securitas.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.securitas.core.AccessCodeCredential;
import com.securitas.core.builder.Trama;
import com.securitas.core.builder.TramaBuilder;
import com.securitas.core.builder.TramaBuilderDirector;

public class TestProtocol {

	private static String getTramaProtocoAccesCode() {
		return "00000000000000000001" +
			   "ACCES" +
			   "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001" +
			   "ABCDE12345FGHIJ6789KLMNOP";
	}
	
	private static String getTramaProtocoFingerPrint() {
		return "00000000000000000001" +
			   "FGRPR" +
			   "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001" +
			   "ABCDE12345FGHIJ6789KLMNOP";
	}
	
	
	@Test
	public void testProtocoAccesCode() {
		//ARRANGE
		TramaBuilderDirector tramaBuilderDirector = new TramaBuilderDirector();
		TramaBuilder builder = new TramaBuilder(getTramaProtocoAccesCode());
		
		//ACT
		Trama trama = tramaBuilderDirector.construct(builder);
		
		//ASSER
		assertNotNull(trama);
		assertTrue(trama.getCredential() instanceof AccessCodeCredential);
	}

	@Test
	public void testProtocoFingerPrint() {
		//ARRANGE
		TramaBuilderDirector tramaBuilderDirector = new TramaBuilderDirector();
		TramaBuilder builder = new TramaBuilder(getTramaProtocoFingerPrint());
		
		//ACT
		Trama trama = tramaBuilderDirector.construct(builder);
		
		//ASSER
		assertNotNull(trama);
		assertTrue(trama.getCredential() instanceof AccessCodeCredential);
	}

}
