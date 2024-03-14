package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10]; // backing Object array, which refers to an array of size 10 initially;
	private int size;
	

	@Override
	public boolean add(T item) { // append item at the next available spot
		
		int currentLength = items.length;
		if (size < currentLength) {
			items[size] = item;
			size++;
		} else {
			doubleAndAdd(item);
		}
		
		return true;
		
	}
	

	private void doubleAndAdd(T item) {
		// TODO Auto-generated method stub
		int newSize = items.length * 2;
		Object[] newArray = new Object[newSize];
		System.arraycopy(items, 0, newArray, 0, size);
		items = newArray;
		items[size] = item;
		size++;
	}


	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", but size is: " + size);
		}
		return (T) items[index];
	}
	
	
}
