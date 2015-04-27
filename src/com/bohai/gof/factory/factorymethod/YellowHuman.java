package com.bohai.gof.factory.factorymethod;

public class YellowHuman implements Human {

	@Override
	public void getColor() {
		System.out.println("黄色");
	}

	@Override
	public void talk() {
		System.out.println("我是中国人");
	}

}
