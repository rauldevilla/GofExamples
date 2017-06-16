package com.creditall.core;

public class AdvisorApprover implements Approver {

	@Override
	public void handle(Credit credit) {
		if (credit.getValue() <= 5000 && credit.getValue() > 1000) {
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
		return new BoardApprover();
	}

}
