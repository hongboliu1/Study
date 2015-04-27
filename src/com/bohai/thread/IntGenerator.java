package com.bohai.thread;
/**
 * 功能产生一个整数
 */
public abstract class IntGenerator {

	private boolean cancel = false;

	public abstract int next();

	public void cancel() {
		this.cancel = true;
	}

	public boolean isCancel() {
		return this.cancel;
	}

}
