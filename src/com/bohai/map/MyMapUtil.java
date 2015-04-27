package com.bohai.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MyMapUtil {

    public static <K,V> List<V> getAll(List<K> keys,Map<K,V> source) {
    	List<V> values = Collections.emptyList();
    	if (keys != null && !keys.isEmpty() && source != null && !source.isEmpty()) {
    		values = new ArrayList<V>();
        	for (K k : keys) {
        		values.add(source.get(k));
    		}
    	}
    	return values;
    }
	
	public static void main(String[] args) {
		Map<Integer,String> m = new HashMap<Integer, String>();
		for (int i = 0 ; i < 10 ; i++) {
			m.put(i, String.valueOf(i * 10));
		}
		List<String> val = getAll(Arrays.asList(1,7,9),m);
		for (String string : val) {
			System.out.println(string);
		}
	}
}
