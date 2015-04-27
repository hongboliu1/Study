package com.bohai.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueueThread {

	private BlockingQueue<Object> eggs = new ArrayBlockingQueue<Object>(5); 
	
	public Object getEgg() {
		Object egg = null;  
		try {
			egg = eggs.take();// 从盘子开始取一个鸡蛋，如果盘子空了，当前线程阻塞  
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// 下面输出有时不准确，因为与take操作不是一个原子操作  
        System.out.println("拿到鸡蛋");  
        return egg;  
	}
	
	public void addEgg(Object egg) {
		try {
			eggs.put(egg);// 向盘子末尾放一个鸡蛋，如果盘子满了，当前线程阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 下面输出有时不准确，因为与put操作不是一个原子操作
		System.out.println("放入鸡蛋");
	}
	
	public static void main(String[] args) {
		Plate plate = new Plate();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new AddEggThread(plate));
			exec.execute(new GetEggThread(plate));
		}
		exec.shutdown();
	}
}
