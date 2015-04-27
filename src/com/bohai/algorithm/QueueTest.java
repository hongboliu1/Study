package com.bohai.algorithm;


public class QueueTest {

	public static void main(String[] args) throws Exception{
		Queue<Integer> qu = new Queue<Integer>();
		qu.append(123);
		qu.append(456);
		qu.append(789);
		qu.append(741);
		System.out.println(qu.getFrist());
		qu.delete();
		System.out.println(qu.getFrist());
		for (Integer val : qu) {
			System.out.print(val);
			System.out.print('\t');
		}
	}
}
