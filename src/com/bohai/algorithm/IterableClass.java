package com.bohai.algorithm;

import java.util.Iterator;

public class IterableClass implements Iterable<String> {

	protected String[] words = "And that is now we know the Earth to bo banana-shaped".split(" ");
	
	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			int index = 0;
			@Override
			public boolean hasNext() {
				return index < words.length;
			}

			@Override
			public String next() {
				return words[index++];
			}

			@Override
			public void remove() {
				
			}
			
		};
	}

	public static void main(String[] args) {
		for (String val : new IterableClass()) {
			System.out.print(val + "\t");
		}
	}
}
