/***
 * 在一些应用场合中，某段程序需要等待某个条件达到要求后才能执行，或者等待一定长的时间后此行，从jdk1.5开始就可以使用CountDownLatch实现，    
 * CountDownLatch类是一个同步倒数计数器,构造时传入int参数,该参数就是计数器的初始值，每调用一次countDown()方法，计数器减1,计数器大于0 时，
 *  await()方法会阻塞后面程序执行，直到计数器为0，await(long timeout, TimeUnit unit)，是等待一定时间，然后执行，不管计数器是否到0了。
 *  下面举一个等车的例子：
   10个同学上车，车等待同学上车，如果有等待时间限制，到时间就开走，不管学生上没上完。如果没有等待时间，学生上完了再开： 
 */
package com.bohai.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

	public static int numberOfPeople = 10;//等车的学生数
	
	public static boolean isGone = false;//车开的标志
	
	public static int carWaitTime = 8;//车等的时间
	
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch countDownLatch = new CountDownLatch(numberOfPeople);
		ExecutorService exec = Executors.newSingleThreadExecutor();
		exec.execute(new GetOn(countDownLatch));
		exec.shutdown();
		//new Thread(new GetOn(countDownLatch)).start();
		
		waitStudentGetOn(countDownLatch); //等所有的学生上车
		driveHome();
	}
	
	public static void waitStudentGetOn(CountDownLatch waitStudentsGetOn) throws InterruptedException {
		 System.out.println("赶紧的,抓紧时间上车..");
		 //waitStudentsGetOn.await(carWaitTime, TimeUnit.SECONDS);//等5秒，还没上车，就开走。。
		 waitStudentsGetOn.await();// 等待所有人都上车，才走开
	}
	
	public static void driveHome() throws InterruptedException {
		System.out.println("开车，鞋儿破 帽儿破 身上的袈裟破 你笑我 他笑我 一把扇儿破");
		isGone = true;
	}
}
