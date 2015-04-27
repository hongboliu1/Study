package com.bohai.algorithm;



public class InsertSortTest {

	public static void main(String[] args) {

		int[] arr = {9,8,10,7,5,6,3,2,4,-1};
		SortUtil.showArr(arr);
		insertSort(arr);
		SortUtil.showArr(arr);
		
	}
	
	/**
	 * 思路：在没有排好序的数据中从左至右依次选择一个数据
	 * 与排好序的数据从右至左进行比较，如果排好序的数据大
	 * 于待排序的数据，排好序的数据依次后移
	 * @param arr
	 */
	public static void insertSort(int[] arr) {
		for (int i = 0,len = arr.length; i < len - 1; i++) {
			int j = i;
			int temp = arr[j + 1];
			while (j > -1 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j --;
			}
			arr[j + 1] = temp;
		}
	}
}
