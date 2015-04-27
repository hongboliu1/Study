package com.bohai.algorithm;

public class BubbleSortTest {

	public static void main(String[] args) {
		int[] arr = {9,8,10,7,5,6,3,2,4,-1};
		SortUtil.showArr(arr);
		bubbleSort(arr);
		SortUtil.showArr(arr);
	}

	/**
	 * 进行n-1次循环，数据最未端是排好序的
	 * @param arr
	 */
	public static void bubbleSort(int[] arr) {
		for (int i = 0,len = arr.length; i < len - 1 ; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
