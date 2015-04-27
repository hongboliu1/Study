package com.bohai.algorithm;

public class PalindromeTest {

	public static void main(String[] args) {
		//String str = "ABDBA";
		for (int i = 0,n = 0; i < 1000; i++) {
			if (isPalindrome(String.valueOf(i))) {
				n++;
				System.out.print(i);
				System.out.print('\t');
				if (n % 5 == 0) {
					System.out.println();
				}
			}
		}
	}
	
	public static boolean isPalindrome(String str) {
		boolean result = true;
		int length = str.length();
		for (int i = 0,j = length -1; i < j; i++,j--) {
			if (str.charAt(i) != str.charAt(j)) {
				result = false;
				break;
			}
		}
		return result;
	}
	
}
