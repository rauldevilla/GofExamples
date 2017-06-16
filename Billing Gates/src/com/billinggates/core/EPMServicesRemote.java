package com.billinggates.core;

public class EPMServicesRemote implements EPMServices {

	public EPMServicesRemote() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String pay(Invoice invoice) {
		return "001";
	}
	

}
