package com.bohai.algorithm;

public class SelectSortTest {

	public static void main(String[] args) {
		int[] arr = {9,8,10,7,5,6,3,2,4,-1};
		SortUtil.showArr(arr);
		selectSort(arr);
		SortUtil.showArr(arr);
	}
	
	/**
	 * 思路：从未排好序的数据中选择一个最小，与当前数据进行交换
	 * @param arr
	 */
	public static void selectSort(int[] arr) {
		for (int i = 0 ,len = arr.length;i < len -1 ;i ++) {
			int temp = arr[i];
			int k = i;
			for (int j = i + 1; j < len; j++) {
				if (temp > arr[j]) {
					temp = arr[j];
					k = j;
				}
			}
			if (k != i) {
				temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
	}
}
