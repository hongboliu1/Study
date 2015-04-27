package com.bohai.gof.strategy;

public class Price {

	private MemberStrategy memberStrategy;

	public Price(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}
	
	public double quote(double price) {
		return memberStrategy.calcPrice(price);
	}
	
	public void setMemberStrategy(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}
}
