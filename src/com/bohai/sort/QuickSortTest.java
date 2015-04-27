package com.bohai.sort;


public class QuickSortTest {

	public static void quickSort(int[] arr ,int low,int hight) {
		int i = low,j = hight,temp = arr[i];
		while (i < j ) {
			while (i < j && temp < arr[j]) {
				j --;
			}
			if (i < j ) {
				arr[i] = arr[j];
				i ++;
			}
			while (i < j && temp > arr[i]) {
				i ++;
			}
			if (i < j) {
				arr[j] = arr[i];
				j --;
			}
		}
		arr[i] = temp;
		if (low < i) {
			quickSort(arr ,low,i -1);
		}
		if (hight > j) {
			quickSort(arr ,j + 1,hight);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {12,52,63,89,56,32,97,64,83,69,36};
		showArr(arr);
		quickSort(arr, 0, arr.length -1);
		showArr(arr);
	}
	public static void showArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}
}
