package com.callemuro.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.callemuro.core.Share;
import com.callemuro.core.StockBoard;

public class TestStockBoard {

	@Test
	public void test() {
		StockBoard stockBoard = new StockBoard();
		
		Share googleShare = new Share("Google", 10);
		googleShare.attach(stockBoard);
		
		googleShare.setValue(20);
				
		Share share = stockBoard.getShare("Google");
		
		assertEquals(20f, share.getValue(), 0.01);
		assertEquals(45f, stockBoard.getMarketValue(), 0.01);
	}

}
