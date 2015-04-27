package com.bohai.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class YHDCollectionUtils {
	
	public static final Collection NULL_COLLECTION = new NullCollection();
		
	public static final <T> Collection<T> nullCollection() {
		return (List<T>) NULL_COLLECTION;
	}
	
	public static <K,V> List<V> getAllFormMap(List<K> keys,Map<K,V> source) {
		List<V> values = Collections.emptyList();
		if (keys != null && !keys.isEmpty() && source != null && !source.isEmpty()) {
			values = new ArrayList<V>();
	    	for (K k : keys) {
	    		values.add(source.get(k));
			}
		}
		return values;
	}

	public static <E> void swap(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}
	
	public static <E> List<E> reverse(List<E> list) {
		if (list != null && !list.isEmpty()) {
			int size = list.size();
			for (int i = 0, n = size/2; i < n; i++) {
				E temp = list.get(i);
				list.set(i, list.get(size - 1 -i));
				list.set((size - 1 -i), temp);
			}
		}
		return list;
	}
}
