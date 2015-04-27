package com.bohai.thread.countdownlatch;

import java.util.concurrent.TimeUnit;

public class Student {
	private int myNum;
	public Student(int num) {
		this.myNum = num;
	}
	
	public boolean getOn() throws InterruptedException {
		//Thread.currentThread().sleep(new Random().nextInt(2) * 1000);// 小朋友上车是需要时间的
		//TimeUnit.MICROSECONDS.sleep(new Random().nextInt(2) * 1000);// JDK1.5 后使用这个方式
		TimeUnit.SECONDS.sleep(2);
		if (CountDownLatchTest.isGone) {
			return false;
		}
		System.out.print("编号为:"+myNum+"的同学上车了..");
		return true;
	}
}
