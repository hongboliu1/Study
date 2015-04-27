package com.bohai.algorithm;

public class QuickSortTest {

	public static void main(String[] args) {
		int[] arr = {9,8,10,7,5,6,3,2,4,-1};
		SortUtil.showArr(arr);
		quickSort(arr,0,arr.length -1);
		SortUtil.showArr(arr);
	}

	public static void quickSort(int[] arr,int low ,int high) {
		int i = low;
		int j = high;
		int temp = arr[i];
		while(i < j) {
			while (i < j && temp < arr[j]) {
				j--;
			}
			if (i < j) {
				arr[i] = arr[j];
			}
			while (i < j && temp > arr[i]) {
				i++;
			}
			if (i < j) {
				arr[j] = arr[i];
			}
		}
		arr[i] = temp;
		if (low < i - 1) {
			quickSort(arr,low,i -1);
		}
		if (j + 1 < high) {
			quickSort(arr,j + 1,high);
		}
	}
}
