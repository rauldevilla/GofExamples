package com.billinggates.core;

public class BillingGates {

	public String pay(Invoice invoice) {
		ServiceCompanyServices services = new EPMServicesProxy();
		return services.pay(invoice);
	}

}
