package com.creditall.core;

public class InstantApprover implements Approver {

	@Override
	public void handle(Credit credit) {
		if (credit.getValue() <= 1000 && credit.getClient().getProfile() == ClientProfile.GREEN) {
			credit.setStatus(CreditStatus.APPROVED);
			credit.setApprover(this);
		} else {
			if (getSuccesor() == null) {
				credit.setStatus(CreditStatus.REJECTED);
				credit.setApprover(null);
			} else {
				getSuccesor().handle(credit);
			}
		}
	}

	@Override
	public Approver getSuccesor() {
		return new AdvisorApprover();
	}

}
