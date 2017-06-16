package com.noteit.core;

public class TextDecorator {

	public Text setBold(Text text) {
		return new BoldText(text);
	}

}
