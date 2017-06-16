package com.callemuro.core;

import java.util.Scanner;

public class UserInputRunnable implements Runnable {

	private boolean stoped = false;
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
		this.stoped = true;
	}
	
	public boolean stop() {
		return this.stoped;
	}

}
