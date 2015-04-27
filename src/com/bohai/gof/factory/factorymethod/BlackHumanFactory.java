package com.bohai.gof.factory.factorymethod;

public class BlackHumanFactory extends AbstractFactory {

	@Override
	public Human createHuman() {
			return new BlackHuman();
	}
}
