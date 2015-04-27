package com.bohai.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveListNull {

	public static void main(String[] args) {
		List<Integer> arrays = new ArrayList<Integer>();
		arrays.add(2);
		arrays.add(null);
		arrays.add(456);
		arrays.add(null);
		arrays.add(789);
		arrays.removeAll(Collections.singleton(null));
		System.out.println(arrays);
	}

}
