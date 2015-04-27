package com.bohai.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class GetOn implements Runnable {

	private CountDownLatch		countDownLatch;
	
	public GetOn(CountDownLatch		countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < CountDownLatchTest.numberOfPeople; i++) {
			try {
				if (CountDownLatchTest.isGone) {
					 System.out.println("还差："+countDownLatch.getCount()+" 个没娃上车呢.怎么车走了");
					 break;
				} 
				boolean goonSuccess = new Student(i + 1).getOn();//顺序上车
				if (goonSuccess) {
					// 每当小朋友上车成功后，就调用 countDown() 进行减1操作
					countDownLatch.countDown();
				}
			} catch (InterruptedException  e) {}
			if (countDownLatch.getCount() != 0) {
				System.out.println("还差："+(countDownLatch.getCount())+" 个没上车");
			} else {
				System.out.println("都上车了");
			}
		}
	}
}
