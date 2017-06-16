package com.callemuro.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	private List<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
		this.observers.add(observer);
	}
	
	protected void notifyObservers() {
		for (Observer o : this.observers) {
			o.upadate(this);
		}
	}
}
