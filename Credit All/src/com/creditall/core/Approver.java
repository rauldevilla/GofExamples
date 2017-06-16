package com.creditall.core;

public interface Approver {

	void handle(Credit credit);
	Approver getSuccesor();

}
