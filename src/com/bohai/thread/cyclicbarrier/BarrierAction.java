package com.bohai.thread.cyclicbarrier;

public class BarrierAction implements Runnable {

	@Override
	public void run() {
		System.out.println("全部线程已执行完毕！");
	}
}
