package com.bohai.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		/*
		List<Integer> arrays = new ArrayList<Integer>();
		long time1 = System.currentTimeMillis();  
		for (int i = 0; i < 1000000; i++) {
			arrays.add(i);
		}
		long time2 = System.currentTimeMillis();  
		List<Integer> pointers = new LinkedList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			pointers.add(i);
		}
		long time3 = System.currentTimeMillis();  
		
	   System.out.println("ArrayList:" + (time2 - time1));  
	   System.out.println("LinkedList:" + (time3 - time2));  
	  */
		List<Integer> l = new LinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			l.add(i);
		}
		System.out.println(l);
		System.out.println(YHDCollectionUtils.reverse(l));
	}
}
