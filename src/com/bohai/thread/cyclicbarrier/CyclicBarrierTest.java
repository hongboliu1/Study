package com.bohai.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

	private final CyclicBarrier cyclicBarrier;
	private int count;
	
	public CyclicBarrierTest(int count) {
		this.count = count;
		this.cyclicBarrier = new CyclicBarrier(this.count, new BarrierAction());
		
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < this.count; i++) {
			exec.execute(new Worker(i,cyclicBarrier));
		}
		exec.shutdown();
	}
	
	public static void main(String[] args) {
		new CyclicBarrierTest(5);
	}
}