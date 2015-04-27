package com.bohai.thread.account;

public class Account {
	
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public synchronized  void add(int num) {
			this.balance += num;
	}
	
	public synchronized  void withdraw(int num) {
			this.balance -= num;
	}

	public int getBalance() {
		return balance;
	}
	
}
