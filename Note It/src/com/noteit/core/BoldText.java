package com.noteit.core;

public class BoldText extends Text {

	public BoldText(String text) {
		super(text);
	}

	public BoldText(Text text) {
		super(text.getText());
	}
	
	@Override
	public void draw() {
		System.out.println("\\B" + this.getText() + "\\B");
	}

}
