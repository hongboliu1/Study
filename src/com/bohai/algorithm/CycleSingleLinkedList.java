package com.bohai.algorithm;

import java.util.List;

public class CycleSingleLinkedList<E> extends AbstractSingleLinkedList<E> implements List<E> ,java.io.Serializable {

	private static final long serialVersionUID = -2856058002090891038L;


	private transient Entry<E> header = null;
	private transient int size ;
	// 指向最未端
	private transient Entry<E> lastElement = null;
	
	@Override
	public SingleListIterator<E> singleListIterator() {
		return  new SingleIterator();
	}

	public CycleSingleLinkedList() {
		header = new Entry<E>(null, header);
		lastElement = header;
		size ++;
	}
	
	public E getLast() {
		return lastElement.element;
	}
	
	@Override
	public boolean remove(Object o) {
		boolean result = false;
		if (o == null) {
			for (Entry<E> beforElement = header,currentElement = beforElement.next; currentElement != header; beforElement = beforElement.next,currentElement = beforElement.next) {
				if (currentElement != null && currentElement.element == null) {
					beforElement.next = currentElement.next;
					result = true;
					if (currentElement.equals(lastElement)) {
						lastElement = beforElement;
					}
					size --;
				}
			}
			
		} else {
			for (Entry<E> beforElement = header,currentElement = beforElement.next; currentElement != header; beforElement = beforElement.next,currentElement = beforElement.next) {
				if (currentElement != null && o.equals(currentElement.element)) {
					beforElement.next = currentElement.next;
					result = true;
					if (currentElement.equals(lastElement)) {
						lastElement = beforElement;
					}
					size --;
				}
			}
		}
		return result;
	}
	
	@Override
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index+
                    ", Size: "+size);
		}
		Entry<E> e = header;
		Entry<E> before = header;
		for (int i = 0; i < index; i++) {
			before = before.next;
		}
		e = before.next;
		before.next = e.next;
		if (index == size() -1) {
			lastElement = before;
		}
		size --;
		return e.element;
	}	
	
	@Override
	public void add(int index,E element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index+
                    ", Size: "+size);
		}
		Entry<E> e = header;
		Entry<E> before = header;
		for (int i = 0; i < index; i++) {
			before = before.next;
		}
		e = before.next;
		before.next = new Entry<E>(element, e);
		size ++;
	}

	@Override
	public boolean add(E e) {
		lastElement.next = new Entry<E>(e, header); 
		lastElement = lastElement.next;
		size ++;
		return true;
	}
	
	@Override
	public E get(int index) {
		return entry(index).element;
	}
	
	private Entry<E> entry(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: "+index+
                    ", Size: "+size);
		}
		Entry<E> e = header;
		for (int i = 0; i <= index; i++) {
			e = e.next;
		}
		return e;
	}
	
	@Override
	public int size() {
		return size - 1;
	}

	private static class Entry<E> {
		E element;
		Entry<E> next;
		public Entry(E element, Entry<E> next) {
			this.element = element;
			this.next = next;
		}
	}
	
	private class SingleIterator implements SingleListIterator<E> {
		
		// 最后访问的结点
		private Entry<E> lastReturned = header.next;
		// 中间访问的结点
		private Entry<E> beforeElement = header;
		// 最前访问的结点
		private Entry<E> previousElement = beforeElement;
		
		@Override
		public boolean hasNext() {
			// 非循环单链表最后是null
			return lastReturned != header;
		}

		@Override
		public E next() {
			previousElement = beforeElement;
			beforeElement = lastReturned;
			E e = lastReturned.element;
			lastReturned = lastReturned.next;
			return e;
		}

		@Override
		public void remove() {
			previousElement.next = lastReturned;
			// 删除的是中间的结点，删除完后，中间的结点指向最前结点
			beforeElement = previousElement;
			size --;
		}

		@Override
		public void set(E e) {
			beforeElement.element = e;
		}

		@Override
		public void add(E e) {
			// 若前后结点与中单结点相等，是在执行删除后，接着执行add操作
			if (previousElement == beforeElement) {
				previousElement.next = beforeElement = new Entry<E>(e, lastReturned);
			} else {
				previousElement.next = new Entry<E>(e, beforeElement);
			}
			size ++;
		}
	}
	
}
