package com.callemuro.core;

public class StockMarketSimulator {

	private Share[] shares;
	private Broker[] brokers;
	private Thread brokerTransactionsThread;
	private BrokerTransactionsRunnable brokerTransactionsRunnable;
	
	public StockMarketSimulator(Share[] shares) {
		this.shares = shares;
	}
	
	private void startBrokers() {
		this.brokers = new Broker[] {
			new Broker("Jhon"),
			new Broker("Maria")
		};
	}
	
	private void openMarketTransactions(Broker[] brokers, Share[] shares) {
		this.brokerTransactionsRunnable = new BrokerTransactionsRunnable(brokers, shares);
		this.brokerTransactionsThread = new Thread(this.brokerTransactionsRunnable);
		this.brokerTransactionsThread.start();
	}
	
	private void closeMarket() {
		this.brokerTransactionsRunnable.stop();
	}
	
	public void start() throws InterruptedException {
		UserInputRunnable userInputRunnable = new UserInputRunnable();
		Thread userInputThread = new Thread(userInputRunnable);
		
		startBrokers();
		openMarketTransactions(brokers, shares);
		
		userInputThread.start();
		boolean marketIsOpen = true;
		while (marketIsOpen) {
			if (userInputRunnable.stop()) {
				marketIsOpen = false;
				closeMarket();
				break;
			}
			Thread.sleep(1000);
		}
		
		userInputThread.join();
		this.brokerTransactionsThread.join();
	}

}
