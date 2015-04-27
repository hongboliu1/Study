package com.bohai.util;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < 10; i++) {
			st.push(i);
		}
		
		
		for (int i = 0; i < 10; i++) {
			Integer val = st.pop();
			//Integer val = st.top();
			System.out.print(val);
			System.out.print('\t');
		}
		
		
		for (Integer val : st) {
			System.out.print(val);
			System.out.print('\t');
		}
		
	}

}
