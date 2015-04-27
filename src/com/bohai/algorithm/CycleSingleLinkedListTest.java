package com.bohai.algorithm;

import com.bohai.util.YHDCollectionUtils;

public class CycleSingleLinkedListTest {

	public static void main(String[] args) {
		CycleSingleLinkedList<Integer> list = new CycleSingleLinkedList<Integer>();
		list.add(456);
		list.add(0,123);
		list.add(789);
		list.add(963);
		list.add(852);
		list.add(null);
		list.add(null);
		
		list.removeAll(YHDCollectionUtils.nullCollection());
		
		for (Integer val : list) {
			System.out.println(val);
		}
	}

}
