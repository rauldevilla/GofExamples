package com.callemuro.core;

import java.util.Random;

public class BrokerTransactionsRunnable implements Runnable {

	private boolean isProcessing = true;
	private Broker[] brokers;
	private Share[] shares;
	
	public BrokerTransactionsRunnable(Broker[] brokers, Share[] shares) {
		this.brokers = brokers;
		this.shares = shares;
	}
	
	private static float getTransactionValue(float limit) {
		int localLimit = limit <= 0 ? 100 : (int)limit;
		Random rnd = new Random();
		return (float)rnd.nextInt(localLimit);
	}
	
	private void doTransactions() {
		float value = 0;
//		for (Broker b : this.brokers) {
			for (Share s : this.shares) {
				value = getTransactionValue(s.getValue());
				System.out.println("Value: " + value);
				s.setValue(value);
			}
//		}
	}

	@Override
	public void run() {
		while (this.isProcessing) {
			
			doTransactions();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				break;
			}
		}

	}

	public void stop() {
		this.isProcessing = false;
	}

}
