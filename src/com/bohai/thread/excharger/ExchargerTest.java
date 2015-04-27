package com.bohai.thread.excharger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 案例：服务员向原有空杯中不断倒水，消费者不断从原有装满水的杯中喝水。  
 * 当服务员倒满水和消费者喝完水时，两个杯子进行交换。一直这样周而复始。 
 * @author liuhongbo
 *
 */
public class ExchargerTest {
	
	static Exchanger<Cup> exchanger = new Exchanger<Cup>();
	// 初始化时，100 只杯子都是满的
	static Cup fullCup = new Cup(100);
	static Cup emptyCup = new Cup(0);
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Waiter(3));
		exec.execute(new Customer(6));
		exec.shutdown();
	}

	static class Waiter implements Runnable {

		int addSpeed = 1;
		public Waiter(int addSpeed) {
			this.addSpeed = addSpeed;
		}
		
		@Override
		public void run() {
			while (emptyCup != null) {
				try {
					// 如果空杯都是满的，
					if (emptyCup.isFull()) {
						// 当waiter把空杯装满水后，与Customer交换杯子
						// exchange(emptyCup) 中参数的emptyCup是waiter装满水后的，把装满水后的emptyCup参数传递给cutomer线程。
						// 并且返回cutomer线程中fullCup给waiter的emptyCup，这样达到交换本子的目的
						emptyCup = exchanger.exchange(emptyCup);
					} else {
						// 有空杯，但不都是空杯，住空杯中加水
						emptyCup.addWaterToCup(addSpeed);
						System.out.println("Waiter add " + addSpeed + "  and current capacity is " + emptyCup.capacity);  
						TimeUnit.SECONDS.sleep(1L);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Customer implements Runnable {
		int drinkSpeed = 1;

		public Customer(int drinkSpeed) {
			this.drinkSpeed = drinkSpeed;
		}
		
		@Override
		public void run() {
			while (fullCup != null) {
				try{
					// 如果满杯是空的，则进行交换
					if (fullCup.isEmpty()) {
						fullCup = exchanger.exchange(fullCup);
						System.out.println("Customer: " + fullCup.capacity);
					} else {
						// 如果满杯不全是空的，客户drink
						fullCup.drinkFormCup(drinkSpeed);
						System.out.println("Customer drink "+ drinkSpeed + " and current capacity is " + fullCup.capacity);
						TimeUnit.SECONDS.sleep(2L);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Cup {
		private int capacity = 0;
		public Cup(int capacity) {
			this.capacity = capacity;
		}
		
		public void addWaterToCup(int i) {
			capacity += i;
			capacity = capacity > 100 ? 100 : capacity;
		}
		public void drinkFormCup(int i) {
			capacity -= i;
			capacity = capacity < 0 ? 0 : capacity;
		}
		public boolean isFull() {
			return capacity == 100 ? true : false;
		}
		public boolean isEmpty() {
			return capacity == 0 ? true : false;
		}
	}
}
