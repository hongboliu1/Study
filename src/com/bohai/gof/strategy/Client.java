package com.bohai.gof.strategy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MemberStrategy memberStrategy = new AdvancedMemberStrategy();
		Price price = new Price(memberStrategy);
		double resultPrice = price.quote(100);
		System.out.println("图书的最终价格是：" + resultPrice);
	}
}
