package com.bohai.gof.factory.abstractfactory;

public class MaleBlackHuman extends AbstractBlackHuman {

	@Override
	public void getSex() {
		System.out.println("我是男人");
	}
}
