package com.bohai.algorithm;

import java.util.ArrayList;
import java.util.List;



public class SingleLinkedListTest {

	public static void main(String[] args) {
		SingleLinkedList<Integer> arr = new SingleLinkedList<Integer>();
		arr.add(456);
		arr.add(789);
		arr.add(0,123);
		arr.add(789);
		arr.add(741);
		//arr.remove(3);
		arr.add(963);
		
		SingleListIterator<Integer> it = arr.singleListIterator();
		
		System.out.println(arr.size());
		
		List<Integer> remove = new ArrayList<Integer>();
		remove.add(789);
		
		while (it.hasNext()) {
			Integer val = it.next();
			if (remove.contains(val)) {
				it.remove();
			}
		}
		
		for (Integer integer : arr) {
			System.out.println(integer);
		}
		
		System.out.println(arr.size());
	}
}
