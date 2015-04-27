package com.bohai.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

	private int index;
	private CyclicBarrier cyclicBarrier;
	
	public Worker(int index,CyclicBarrier cyclicBarrier) {
		this.index = index;
		this.cyclicBarrier = cyclicBarrier;
	}
	
	@Override
	public void run() {
		System.out.println("第"+ index +"个线程休眠"+(2 * index) +"秒！");
		try {
			TimeUnit.SECONDS.sleep(2 * index);
		} catch (Exception e) {
			
		}
		System.out.println( "第"  + index +  "个线程结束休眠！" );  
		try {
			// 在这里待，所有线程到达后，才往下执行
			cyclicBarrier.await();
		} catch (Exception e) {
			
		}
		// 所有线程到达后，执行这里
		System.out.println(index);
	}
}
