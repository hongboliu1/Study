package com.bohai.gof.factory.abstractfactory;

public abstract class AbstractWhiteHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("黄人");
	}

	@Override
	public void talk() {
		System.out.println("我是中国人");
	}
}
