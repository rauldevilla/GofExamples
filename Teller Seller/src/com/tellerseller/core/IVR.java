package com.tellerseller.core;

import java.util.ArrayList;
import java.util.List;

public class IVR {

	private static IVR instance;
	
	private static final int MAX_PHONE_CALLS_ALLOWED = 10;
	
	private List<PhoneCall> phoneCalls = new ArrayList<>();
	
	private IVR() {
	}
	
	public static IVR getInstance() {
		if (instance == null) {
			loadInstance();
		}
		return instance;
	}
	
	private static synchronized void loadInstance() {
		if (instance == null) {
			instance = new IVR();
		}
	}
	
	public void connect(Operator operator) {
		// TODO Auto-generated method stub
		
	}

	private boolean maxPhoneCallsExceded() {
		return this.phoneCalls.size() == MAX_PHONE_CALLS_ALLOWED;
	}
	
	public void receive(PhoneCall phoneCall) throws TooManyPhoneCallsException {
		synchronized (this.phoneCalls) {
			if (maxPhoneCallsExceded()) {
				throw new TooManyPhoneCallsException();
			}
			this.phoneCalls.add(phoneCall);
		}
	}

	public int getActivePhoneCalls() {
		return this.phoneCalls.size();
	}

}
