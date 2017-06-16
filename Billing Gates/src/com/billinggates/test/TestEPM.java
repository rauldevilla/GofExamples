package com.billinggates.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.billinggates.core.BillingGates;
import com.billinggates.core.Client;
import com.billinggates.core.EPMServicesProxy;
import com.billinggates.core.Invoice;
import com.billinggates.core.ServicesCompany;

public class TestEPM {

	@BeforeClass
	public static void init() {
		System.out.println(new Date()+ " -- Iniciando");
		new EPMServicesProxy();
		System.out.println(new Date()+ " -- Iniciado !!!");
	}
	
	private static Invoice getInvoice(String clientName, String companyName, int value) {
		Invoice invoice = new Invoice();
		ServicesCompany company = new ServicesCompany(clientName);
		Client client = new Client(clientName);
		
		invoice.setValue(value);
		invoice.setCompany(company);
		invoice.setClient(client);
		
		return invoice;
	}
	
	@Test(timeout = 1000)
	public void test001() {
		BillingGates billingGates = new BillingGates();

		Invoice invoice = getInvoice("Nestor", "epm", 100000);
		String transactionId = billingGates.pay(invoice);
		assertEquals("001", transactionId);
	}

	@Test(timeout = 1000)
	public void test002() {
		BillingGates billingGates = new BillingGates();

		Invoice invoice = getInvoice("Diego", "epm", 100000);
		String transactionId = billingGates.pay(invoice);
		assertEquals("001", transactionId);

		assertEquals("001", transactionId);
	}

}
