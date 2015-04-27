package com.bohai.gof.factory.abstractfactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HumanFactory factory = new MaleHumanFactory();
		Human human = factory.createBlackHuman();
		human.getColor();
		human.getSex();
		human.talk();
	}
}
