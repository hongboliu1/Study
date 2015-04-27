package com.bohai.algorithm;

public class BinarySearchTest {

	public static void main(String[] args) {
		int arr[] = new int[10];
		int data = -1;
		for (int i = 1; i <= 10;i++) {
			arr[i - 1] =i; 
		}
		SortUtil.showArr(arr);
		System.out.println(binarySearch(arr,data));
		System.out.println(binarySearch(arr,0,arr.length - 1,data));
	}
	
	/**
	 * 循环实现
	 * @param arr
	 * @param data
	 * @return
	 */
	public static int binarySearch(int[] arr ,int data){
		int low = 0,high = arr.length - 1,index = -1;
		while (low <= high) {
			int mid = (low + high)/2;
			if (arr[mid] == data) {
				index = mid;
				break;
			} else if (arr[mid] > data) {
				high = mid - 1;
			} else if (arr[mid] < data) {
				low = mid + 1;
			}
		}
		return index;
	}
	
	/**
	 * 递归实现
	 * @param arr
	 * @param data
	 * @return
	 */
	public static int binarySearch(int[] arr,int low,int high,int data) {
		int mid = (low + high)/2;
		if (arr[mid] == data) {
			return mid;
		} else if (low <= high && arr[mid] > data) {
			return binarySearch(arr,low,mid - 1,data);
		} else if (low <= high && arr[mid] < data) {
			return binarySearch(arr,mid + 1,high,data);
		} else {
			return -1;
		}
	}
}
