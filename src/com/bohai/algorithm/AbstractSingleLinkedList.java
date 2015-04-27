package com.bohai.algorithm;

import java.util.AbstractList;
import java.util.Iterator;

public abstract class AbstractSingleLinkedList<E> extends AbstractList<E> {

	protected AbstractSingleLinkedList(){}
	
	
	@Override
    public Iterator<E> iterator() {
        return singleListIterator();
    }
    
	/**
	 * 返回类型不对
	 * @return
	 */
	public abstract Iterator<E> singleListIterator();
	
}
