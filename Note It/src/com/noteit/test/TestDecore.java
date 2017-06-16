package com.noteit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.noteit.core.BoldText;
import com.noteit.core.Text;
import com.noteit.core.TextDecorator;

public class TestDecore {

	@Test
	public void testABold() {
		Text text = new Text("A");
		text.draw();

		TextDecorator decorator = new TextDecorator(); 
		
		Text boldText = decorator.setBold(text);
		boldText.draw();
		
		assertTrue(boldText instanceof BoldText);
	}

}
