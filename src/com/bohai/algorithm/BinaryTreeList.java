package com.bohai.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinaryTreeList<E> extends AbstractSingleLinkedList<E> implements List<E> ,java.io.Serializable {

	private static final long serialVersionUID = -5672690815694732101L;
	private Entry<E>	root;
	private int size ;
	public BinaryTreeList() {
		this.root = null;
	}
	
	public boolean add(E e) {
		Entry<E> newEntry = new Entry<E>(e,null,null);
		if (this.root == null) {
			this.root = newEntry;
		} else {
			Comparable<? super E> k = (Comparable<? super E>) e;
			Entry<E> currentEntry = this.root;
			Entry<E> parentEntry = null;
			int result = 0;
			while (currentEntry != null) {
				result = k.compareTo(currentEntry.data);
				parentEntry = currentEntry;
				if (result > 0) {
					currentEntry = currentEntry.rigthChild;
				} else {
					currentEntry = currentEntry.leftChild;
				}
			}
			if (result > 0) {
				parentEntry.rigthChild = newEntry;
			} else {
				parentEntry.leftChild = newEntry;
			}
			
		}
		size ++;
		return true;
	}
	
	public Entry<E> getRoot() {
		return this.root;
	}
	
	/**
	 * 使用递归遍历tree
	 * @param tree
	 * @param result
	 * @return
	 */
	private void preOrder(Entry<E> tree,List<E> result) {
		if (tree != null) {
			preOrder(tree.leftChild,result);
			result.add(tree.data);
			preOrder(tree.rigthChild,result);
		}
	}
	
	public List<E> showTree() {
		List<E> result = new ArrayList<E>(size);
		preOrder(getRoot(),result);
		return result;
	}
	
	@Override
	public Iterator<E> singleListIterator() {
		/**
		 * 这个地方怎么样实现呢 ？
		 * 就是怎么样把递归写成循环？
		 */
		return new Iterator<E>() {
			private Entry<E> current = root;
			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public E next() {
				return null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("can not remove");
			}
			
		};
	}

	@Override
	public E get(int index) {
		throw new UnsupportedOperationException("can not get");
	}

	@Override
	public int size() {
		return size;
	}

	public static class Entry<E>{
		E data;
		Entry<E> leftChild;
		Entry<E> rigthChild;
		
		public Entry(E e,Entry<E> leftChild,Entry<E> rigthChild) {
			this.data = e;
			this.leftChild = leftChild;
			this.rigthChild = rigthChild;
		}
	}
}
