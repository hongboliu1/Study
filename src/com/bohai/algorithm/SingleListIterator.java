package com.bohai.algorithm;

import java.util.Iterator;

public interface SingleListIterator<E> extends Iterator<E> {

	boolean hasNext();
	
	E next();
	
	void remove();
	
	void set(E e);
	
	void add(E e);
}
