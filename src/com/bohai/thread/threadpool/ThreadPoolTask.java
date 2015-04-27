package com.bohai.thread.threadpool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTask implements Runnable {

	private final Object threadPoolTaskData;
	private static long consumerTaskSleepTime = 2L;
	
	public ThreadPoolTask(Object tasks) {
		this.threadPoolTaskData = tasks;
	}
	
	@Override
	public void run() {
		System.out.println("start :" + threadPoolTaskData);
		try {
			TimeUnit.SECONDS.sleep(consumerTaskSleepTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("finish " + threadPoolTaskData);   
	}
}
