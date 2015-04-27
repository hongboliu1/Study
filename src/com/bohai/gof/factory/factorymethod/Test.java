package com.bohai.gof.factory.factorymethod;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractFactory factory = new BlackHumanFactory();
		Human human = factory.createHuman();
		human.getColor();
	}
}
