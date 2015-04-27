package com.bohai.thread;

public class GetEggThread implements Runnable {

	private Plate plate;
	public GetEggThread(Plate plate) {
		this.plate = plate;
	}
	@Override
	public void run() {
		plate.getEgg();
	}

}
