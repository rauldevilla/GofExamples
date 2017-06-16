package com.callemuro.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.callemuro.observer.Observer;
import com.callemuro.observer.Subject;

public class StockBoard implements Observer {

	private Float marketValue = new Float(0);
	private List<Share> shares = new ArrayList<>();
	
	private Share findShare(Share share) {
		List<Share> result = this.shares.stream()
								.filter(s -> s.equals(share))
								.collect(Collectors.toList());
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
	public Share getShare(String name) {
		return findShare(new Share(name, -1));
	}
	
	private void addShare(Share share) {
		this.shares.add(share.cloneThis());
	}
	
	private void modifyMarketValue(float newValue) {
		synchronized (this.marketValue) {
			this.marketValue = this.marketValue + newValue;
		}
	}

	private static boolean isGoingUp(Share baseShare, Share newShare) {
		return baseShare.getValue() < newShare.getValue();
	}
	
	private static boolean isGoingDown(Share baseShare, Share newShare) {
		return baseShare.getValue() > newShare.getValue();
	}
	
	private void modifyMarketValue(Share baseShare, Share newShare) {
		if (isGoingUp(baseShare, newShare)) {
			modifyMarketValue(newShare.getValue() - baseShare.getValue());
		} else if (isGoingDown(baseShare, newShare)) {
			modifyMarketValue(baseShare.getValue() - newShare.getValue());
		}
		baseShare.setValue(newShare.getValue());
	}
	
	@Override
	public void upadate(Subject subject) {
		
		if (subject instanceof Share) {
			Share observedShare = (Share)subject;
			Share share = findShare(observedShare);
			
			if (share == null) {
				addShare(observedShare);
				modifyMarketValue(observedShare.getValue());
			} else {
				modifyMarketValue(share, observedShare);
			}
			
		}
		
		showBoard();
	}
	
	public float getMarketValue() {
		return this.marketValue;
	}
	
	private static void cls() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public void showBoard() {
//		cls();
		System.out.println("Market value: " + this.getMarketValue() + "\r\n");
		for (Share s : this.shares) {
			System.out.println(s.getName() + "\t\t" + s.getValue());
		}
	}

}
