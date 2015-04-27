package com.bohai.util;

import java.util.List;

public class MyArrayListTest {

	public static void main(String[] args) {
		int leng = 10;
		List<Integer> t = new MyArrayList<Integer>(10);
		for (int i = 0; i < leng; i++) {
			t.add(i + 1);
		}
		System.out.println(t);
		YHDCollectionUtils.swap(t, 1, 8);
		System.out.println(t);
	}

}
