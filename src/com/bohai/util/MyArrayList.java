package com.bohai.util;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class MyArrayList<E> extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

	private static final long serialVersionUID = -3793852451568290952L;
	
	private Object[] element; 
	
	private int size;
	
	private int length;

	public MyArrayList(int length) {
		this.length = length;
		element = new Object[this.length];
	}
	
	public MyArrayList() {
		this(10);
	}
	
	public void ensureCapacity(int minCapacity) {
		int oldCapacity = element.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3)/2 +1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
				element = Arrays.copyOf(element, newCapacity);
			}
		}
		
	}
	
	@Override
	public boolean add(E obj) {
		ensureCapacity(size + 1);
		element[size++] = obj;
		return true;
	}
	
	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(
					"Index: "+index+", Size: "+size);
		}
	}
	
	@Override
	public E get(int index) {
		rangeCheck(index);
		return (E)element[index];
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E oldElement = (E)element[index];
		for(int i = index, n = size - 1 ; i < n; i++) {
			element[i] = element[i + 1];
		}
		element[--size] = null;
		return oldElement;
	}

	@Override
	public int size() {
		return this.size;
	}
	
	/**
	 * ½«¾ÉÖµ·µ»Ø
	 */
	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		E oldValue = (E)this.element[index];
		this.element[index] = element;
		return oldValue;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
