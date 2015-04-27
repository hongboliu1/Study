package com.bohai.algorithm;

public class FibonacciTest {

public static void main(String[] args) {
	int[] arr = {0,0};
	for (int i = 0; i <= 10; i++) {
		int result = 0;
		if (i <= 1) {
			arr[i] = i;
			result = i;
		} else {
			result = arr[0] + arr[1];
			arr[0] = arr[1];
			arr[1] = result;
		}
		System.out.print(result);
		System.out.print('\t');
	}
}

}
