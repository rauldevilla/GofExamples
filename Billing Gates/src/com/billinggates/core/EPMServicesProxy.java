package com.billinggates.core;

public class EPMServicesProxy implements EPMServices {

	private static EPMServices remote = new EPMServicesRemote();
	
	@Override
	public String pay(Invoice invoice) {
		return remote.pay(invoice);
	}

}
