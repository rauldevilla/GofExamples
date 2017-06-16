package com.creditall.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.creditall.core.AdvisorApprover;
import com.creditall.core.AutomaticApprover;
import com.creditall.core.Client;
import com.creditall.core.ClientProfile;
import com.creditall.core.Credit;
import com.creditall.core.CreditStatus;
import com.creditall.core.InstantApprover;

public class TestAprove {

	@Test
	public void test500Green() {
		AutomaticApprover approver = new AutomaticApprover();
		Credit credit = new Credit();
		Client client = new Client();
		
		client.setProfile(ClientProfile.GREEN);
		
		credit.setValue(500);
		credit.setClient(client);
		
		approver.aprove(credit);
		
		assertEquals(CreditStatus.APPROVED, credit.getStatus());
		assertTrue(credit.getApprover() instanceof InstantApprover);
	}

	@Test
	public void test1100Green() {
		AutomaticApprover approver = new AutomaticApprover();
		Credit credit = new Credit();
		Client client = new Client();
		
		client.setProfile(ClientProfile.GREEN);
		
		credit.setValue(1100);
		credit.setClient(client);
		
		approver.aprove(credit);
		
		assertEquals(CreditStatus.APPROVED, credit.getStatus());
		assertTrue(credit.getApprover() instanceof AdvisorApprover);
	}
}
