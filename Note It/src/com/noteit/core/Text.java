package com.noteit.core;

public class Text {

	private String text;
	
	public Text(String text) {
		this.text = text;
	}

	public void draw() {
		System.out.println(this.text);
	}

	public String getText() {
		return this.text;
	}

}
