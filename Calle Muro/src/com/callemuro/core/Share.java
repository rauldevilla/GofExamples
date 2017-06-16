package com.callemuro.core;

import com.callemuro.observer.Subject;

public class Share extends Subject {

	private String name;
	private float value;
	
	public Share(String name, float value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
		notifyObservers();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Share) || obj == null) {
			return false;
		}
		return ((Share)obj).getName().equals(this.getName());
	}
	
	public Share cloneThis() {
		return new Share(this.name, this.value);
	}
	
}
