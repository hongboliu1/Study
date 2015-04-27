package com.bohai.gof.strategy;

public class IntermediateMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("中级会员的折扣为10%");
		return booksPrice * 0.9;
	}

}
