package com.bohai.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class InitExecutor extends Thread {

	 private int index;
	
	public InitExecutor(int index) {
		this.index = index;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("["+this.index+"] start....");
			TimeUnit.SECONDS.sleep(2);
			System.out.println("["+this.index+"] end.");
		} catch(Exception e) {
			
		}
	}
	public static void main(String args[]){
		//ExecutorService service=Executors.newCachedThreadPool()
		ExecutorService service=Executors.newFixedThreadPool(4);
	    //ExecutorService service=Executors.newSingleThreadExecutor();
	    for(int i=0;i<10;i++){
	     service.execute(new InitExecutor(i));
	    }
	    System.out.println("submit finish");
	    service.shutdown();
	}
}
