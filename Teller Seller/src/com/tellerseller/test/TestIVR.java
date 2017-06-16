package com.tellerseller.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.tellerseller.core.IVR;
import com.tellerseller.core.Operator;
import com.tellerseller.core.PhoneCall;
import com.tellerseller.core.TooManyPhoneCallsException;

public class TestIVR {
	
	public static void connectOperators(IVR ivr, int numOperators) {
		for (int index = 1; index <= numOperators; index++) {
			ivr.connect(new Operator("OPERATOR " + index));
		}
	}
	
	public static void receivePhoneCalls(IVR ivr, int howMany) throws TooManyPhoneCallsException {
		for (int index = 1; index <= howMany; index++) {
			ivr.receive(new PhoneCall("+574555000" + index));
		}
	}
	
	@Test
	public void testPhaneCallOne() throws TooManyPhoneCallsException {
		PhoneCall phoneCall = new PhoneCall("+5745550001");
		IVR ivr = IVR.getInstance();
		
		connectOperators(ivr, 10);
		ivr.receive(phoneCall);
		
		assertEquals(1, ivr.getActivePhoneCalls());
	}

	@Test
	public void testPhaneCallSix() throws TooManyPhoneCallsException {
		IVR ivr = IVR.getInstance();

		connectOperators(ivr, 10);

		receivePhoneCalls(ivr, 5);
		
		ivr.receive(new PhoneCall("+5745550006"));
		
		assertEquals(6, ivr.getActivePhoneCalls());		
	}

	@Test
	public void testPhaneCallEleven() throws TooManyPhoneCallsException {
		IVR ivr = IVR.getInstance();

		connectOperators(ivr, 10);
		
		receivePhoneCalls(ivr, 10);
		
		boolean rejectedPhoneCall = false;
		try {
			ivr.receive(new PhoneCall("+5745550011"));
		} catch (TooManyPhoneCallsException e) {
			rejectedPhoneCall = true;
		}
		
		assertTrue(rejectedPhoneCall);
		assertEquals(10, ivr.getActivePhoneCalls());
	}
	
	

}
