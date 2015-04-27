package com.bohai.thread;

public class AddEggThread implements Runnable {

	private Plate plate;
	private Object egg = new Object();
	public AddEggThread(Plate plate) {
		this.plate = plate;
	}
	
	@Override
	public void run() {
		plate.addEgg(egg);
	}
	
}
