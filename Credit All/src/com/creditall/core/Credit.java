package com.creditall.core;

public class Credit {

	private int value;
	private Client client;
	private CreditStatus status = CreditStatus.REJECTED;
	private Approver approver;
	
	public void setValue(int value) {
		this.value = value;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public CreditStatus getStatus() {
		return this.status;
	}

	public Approver getApprover() {
		return this.approver;
	}

	public int getValue() {
		return this.value;
	}

	public Client getClient() {
		return client;
	}

	public void setStatus(CreditStatus status) {
		this.status = status;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}

}
