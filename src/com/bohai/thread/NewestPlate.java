package com.bohai.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NewestPlate {

	private List<Object> eggs = new ArrayList<Object>();
	
	private Lock lock = new ReentrantLock();
	
	private Condition addCond = lock.newCondition();

	private Condition getCond = lock.newCondition();
	
	public Object getEgg() {
		lock.lock();
		try {
			while(eggs.size() == 0) {
				try {
					getCond.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			Object egg = eggs.get(0);
			eggs.clear(); //清空
			addCond.signalAll();
			System.out.println("拿到鸡蛋");
			return egg;
		} finally {
			lock.unlock();
		}
	}
	
	public void addEgg(Object egg) {
		lock.lock();
		try {
			while(eggs.size() > 0) {
				try {
					addCond.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			eggs.add(egg);
			getCond.signalAll();
			System.out.println("放入鸡蛋");
		} finally {
			lock.unlock();
		}
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
