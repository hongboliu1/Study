package com.bohai.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 校验产生的数据是否为偶数
 *
 */
public class EvenGenerator extends IntGenerator {

	/**
	 * currentEvenValue 是个类变量，会存在线程安全
	 * 
	 */
	private int currentEvenValue = 0;

	private Lock lock = new ReentrantLock();
	/**
	 * 这个方法没能使用同步，每个线程在任何时个都能进入方法体
	 */
	@Override
	public int next() {
		/**
		 1、方法进入后，马上就开启锁机制
		 2、return currentEvenValue; 必须在finally 前面，防止过时的取消锁
		 3、代码块必须使用try-- finally 包含，在finally 里面要做的事情是关闭锁
		 */
		lock.lock();
		try {
			++currentEvenValue;
			++currentEvenValue;
			return currentEvenValue;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
