package com.bohai.thread.account;

import java.util.concurrent.Callable;

public class AddCallable implements Callable<Integer>{

	private Account account;
	private int num;
	public AddCallable(Account account,int num) {
		this.account = account;
		this.num = num;
	}
	
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < 4; i++) {
			account.add(num);
		}
		return account.getBalance();
	}

}
