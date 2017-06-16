package com.callemuro.core;

public class Main {
	
	private static StockBoard board;

	private static Share[] getStockShares() {
		return new Share[] {
			new Share("Google", 150),
//			new Share("Apple", 210),
//			new Share("IBM", 50)
		};
	}
	
	private static void initBoard(Share[] shares) {
		board = new StockBoard();
		for (Share s : shares) {
			s.attach(board);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Share[] shares = getStockShares();
		initBoard(shares);
		StockMarketSimulator simulator = new StockMarketSimulator(shares);
		simulator.start();
	}
	
}
