package com.bohai.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Plate {

	private List<Object> eggs = new CopyOnWriteArrayList<Object>();
	
	public Object getEgg() {
		while (eggs.size() == 0) {
			try {
				synchronized (eggs) {
					eggs.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object egg = eggs.get(0);
		eggs.clear(); // 清空
		synchronized (eggs) {
			eggs.notifyAll(); // 唤醒阻塞队列的某线程进入就绪队列
		}
		System.out.println("拿到鸡蛋");
		return egg;
	}
	
	public void addEgg(Object egg) {
		while (eggs.size() > 0) {
			try {
				synchronized (eggs) {
					eggs.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		eggs.add(egg);
		synchronized (eggs) {
			eggs.notifyAll();
		}
		System.out.println("放入鸡蛋");
	}

	public static void main(String[] args) {
		Plate plate = new Plate();
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			exec.execute(new GetEggThread(plate));
			exec.execute(new AddEggThread(plate));
		}
		exec.shutdown();
	}
}
