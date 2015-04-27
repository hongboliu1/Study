package com.bohai.algorithm;


public final class SortUtil {
	private SortUtil(){};
	
	public static void showArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print('\t');
		}
		System.out.println();
	}
}
