package com.bohai.thread.account;

import java.util.concurrent.Callable;

public class WithdrwaCallable implements Callable<Integer> {

	private Account		account;
	private int num;
	
	public WithdrwaCallable(Account account,int num) {
		this.account = account;
		this.num = num;
	}
	
	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < 200; i++) {
			account.withdraw(num);
		}
		return account.getBalance();
	}
}
