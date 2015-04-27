package com.bohai.algorithm;

import java.util.Arrays;

public class JosephusArray {

	public static void main(String[] args) {
		int m = 20;
		Character[] people = {'A','B','C','D','E','F','G'};
		int length = people.length;
		int num = length;
		Integer[] password = {3,1,7,2,4,8,4};
		int index = 0;
		int position = 1;
		while (num > 0) {
			if (m == position) {
				num --;
				System.out.print(people[index]);
				System.out.print('\t');
				people[index] = null;
				position = 0;
				m = password[index];
			}
			index = (++index % length);
			if (people[index] != null) {
				position ++;
			}
		}
	}
	
	public  static <T> T delete(T[] arr,int index) {
		T result = arr[index];
		int length = arr.length;
		for(int i = index ; i < length -1 ; i++) {
			arr[i] = arr[i+1];
		}
		Arrays.copyOf(arr, length -1);
		return result;
	}
}
