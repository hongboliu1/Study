/**
 * 
 */
package com.bohai.thread.account;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leiruiqi
 *
 */
public class TheadCallTest  {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Account account = new Account(100);
		ExecutorService threadPool = Executors.newFixedThreadPool(2);
		CompletionService<Integer> pool = new ExecutorCompletionService<Integer>(threadPool);
		 
		for(int i = 0; i < 10; i++){
		   pool.submit(new TheadCallTest.AddThread(account,1));
		   pool.submit(new TheadCallTest.SubThread(account,1));
		}
		 
		for(int i = 0; i < 20; i++){
		   Integer result = pool.take().get();
		   System.out.println(result);
		}
		 
		threadPool.shutdown();
	}
	
	static class AddThread implements Callable<Integer>{
		private Account account;
		private int num;
		public AddThread(Account account,int num) {
			this.account = account;
			this.num = num;
		}
		public Integer call(){
			for (int i = 0; i <1000000; i++) {
				account.add(num);
				
			}
		 
		    return account.getBalance();
		}
	}
	
	static class SubThread implements Callable<Integer>{
		private Account account;
		private int num;
		public SubThread(Account account,int num) {
			this.account = account;
			this.num = num;
		}
		public Integer call(){
			for (int i = 0; i <1000000; i++) {
				account.withdraw(num);
				
			} 
		    return account.getBalance();
		}
	}
}
