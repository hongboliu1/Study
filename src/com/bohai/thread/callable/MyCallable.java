package com.bohai.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {

	private int index;
	
	public MyCallable(int index) {
		this.index = index;
	}
	
	@Override
	public String call() throws Exception {
		String result = "";
		switch (index) {
		case 0:
			result = "this is "+ index;
		case 1:
			result = "this is "+ index;
			System.out.println("looping."); 
			TimeUnit.SECONDS.sleep(2);
		case 2:	
			//throw new Exception("Bad flag value!"); 
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newFixedThreadPool(1);
		Future<String> one =  exec.submit(new MyCallable(0));
		System.out.println(one.get());
		
		Future<String> two = exec.submit(new MyCallable(1));
		System.out.println(two.get());
		
		Future<String> three = exec.submit(new MyCallable(2));
		System.out.println(three.get());
		
		exec.shutdown();
	}
}
