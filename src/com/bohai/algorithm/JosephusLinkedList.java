package com.bohai.algorithm;

import java.util.LinkedList;
import java.util.List;

public class JosephusLinkedList {

	public static void main(String[] args) {
		char[] p = {'A','B','C','D','E','F','G'};
		int[] w = {3,1,7,2,4,8,4};
		List<Character> people = new LinkedList<Character>();
		List<Integer> password = new LinkedList<Integer>();
		for (int i = 0; i < w.length; i++) {
			people.add(p[i]);
			password.add(w[i]);
		}
		
		int index = 0 ;
		int position = 1;
		int num = people.size();
		int m = 20;
		while (num > 0) {
			if (position == m) {
				System.out.print(people.remove(index));
				System.out.print('\t');
				m = password.remove(index);
				num --;
				position = 1;
				if (index >= people.size()) {
					index = 0;
				}
			} else {
				if (num > 0) {
					if (index >= people.size() -1) {
						index = 0;
					} else {
						index ++;
					}
					position ++;
				}
			}
		}
	}

}
