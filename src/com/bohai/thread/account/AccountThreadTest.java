package com.bohai.thread.account;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AccountThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Account account = new Account(100);
		long startTime = System.currentTimeMillis();
		/*
		for (int i = 0; i < 200; i++) {
			Thread add = new Thread(new AddThread(account,200));
			Thread withdraw = new Thread(new WithdrwaThread(account,200));
			add.start();
			withdraw.start();
			withdraw.join();
			add.join();
			System.out.println(account.getBalance());
		}
		*/
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new AddThread(account, 200));
			executorService.execute(new WithdrwaThread(account, 200));
		}
		executorService.shutdown();
		System.out.println(account.getBalance());
		System.out.println(System.currentTimeMillis() - startTime);
	}
}
