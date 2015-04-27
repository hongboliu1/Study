package com.bohai.thread.account;


public class AddThread implements Runnable {

	private Account account;
	private int num;
	public AddThread(Account account,int num) {
		this.account = account;
		this.num = num;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <1000000; i++) {
			account.add(num);
		}
	}
}
