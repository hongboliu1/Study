package com.bohai.gof.strategy;

/**
 * 初级用户
 * @author liuhongbo
 *
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	/**
	 * 初级用户没有折扣
	 */
	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("初级用户没有折扣");
		return booksPrice;
	}
}
