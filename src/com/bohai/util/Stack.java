package com.bohai.util;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public class Stack<E> extends AbstractList<E>
implements List<E>, RandomAccess, Cloneable, java.io.Serializable{

	private static final long serialVersionUID = 8499313429353985523L;

	private Object[] elementData; 
	
	private int size;
	
	private int length;
	
	public Stack(int length) {
		this.length = length;
		elementData = new Object[this.length];
	}
	
	public Stack() {
		this(10);
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(
					"Index: "+index+", Size: "+size);
		}
	}
	
	
	public void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			int newCapacity = (oldCapacity * 3)/2 +1;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
				elementData = Arrays.copyOf(elementData, newCapacity);
			}
		}
		
	}
	
	public boolean push(E e) {
		ensureCapacity(size + 1);
		elementData[size++] = e;
		return true;
	}
	
	public E pop() {
		rangeCheck(size - 1);
		E result = (E)elementData[--size];
		elementData[size] = null;
		return result;
	}
	
	public boolean isEmpty() {
		return elementData == null || size == 0;
	}
	
	public E top() {
		rangeCheck(size - 1);
		return (E)elementData[size - 1];
	}
	
	/**
	 * 获取头顶的数据
	 */
	@Override
	public E get(int index) {
		return top();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public Iterator<E> iterator() {
		return new stackIterator();
	}
	
	private class stackIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			return size > 0;
		}

		@Override
		public E next() {
			return (E)elementData[--size];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("can not get");
		}
	}
}
