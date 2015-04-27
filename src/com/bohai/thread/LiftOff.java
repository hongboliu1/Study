
/**
 * NewHeight.com Inc.
 * Copyright (c) 2008-2010 All Rights Reserved.
 */
package com.bohai.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * <pre>
 * 
 * </pre>
 *
 * @author liuhongbo
 * @version $Id: LiffOf.java, v 0.1 2014-1-8 04:46:58 liuhongbo Exp $
 */
public class LiftOff implements Runnable{

	private int num = 10;
	private static int taskCount = 0 ;
	private final int id = taskCount++;
	
	public LiftOff() {}
	public LiftOff(int num) {
		this.num = num;
	}
	
	public String showResult(int count){
		return "#"+ id +"("+ count +")";
	}
	
	@Override
	public void run() {
		String result ;
		while(--num >= 0) {
			try {
				result = showResult(num);
				//Thread.yield();
				TimeUnit.MICROSECONDS.sleep(100L); // 线程的休眠
				System.out.print(result);
				System.out.print('\t');
			} catch (InterruptedException e) {
				e.fillInStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		/*
		for (int i = 0; i < 5; i++) {
			Thread th = new Thread(new LiftOff(10));
			th.start();
		}
		*/
		ExecutorService exec = Executors.newCachedThreadPool();  
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
		System.out.println("Waiting for LiftOff"); 
	}
	
}
