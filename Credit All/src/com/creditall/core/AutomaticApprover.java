package com.creditall.core;

public class AutomaticApprover {

	public void aprove(Credit credit) {
		Approver approver = new InstantApprover();
		approver.handle(credit);
	}

}
