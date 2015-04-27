package com.bohai.thread.account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AccountCallableThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Account account = new Account(100);
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.submit(new AddCallable(account, 100));
		Future<Integer> result =  exec.submit(new WithdrwaCallable(account, 100));
		exec.shutdown();
		System.out.println(result.get());
	}

}
