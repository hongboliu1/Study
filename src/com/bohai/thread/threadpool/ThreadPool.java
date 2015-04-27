package com.bohai.thread.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	private static int executePrograms = 0;
	private static int produceTaskMaxNumber = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3, 
				TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3),new ThreadPoolExecutor.CallerRunsPolicy());
		for(int i = 0 ; i < produceTaskMaxNumber; i ++) {
			try {
				String task = "task@ " + i;
				System.out.println("put " + task);
				threadPoolExecutor.execute(new ThreadPoolTask(task));
				TimeUnit.SECONDS.sleep(executePrograms);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
