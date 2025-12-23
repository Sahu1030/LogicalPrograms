	package com.sarat.DS;

	public class MyArrayList<T> {
	    private Object[] elements;
	    private int size = 0;
	    private static final int DEFAULT_CAPACITY = 10;

	    public MyArrayList() {
	        elements = new Object[DEFAULT_CAPACITY];
	    }

	    // Add element
	    public void add(T element) {
	        ensureCapacity();
	        elements[size++] = element;
	    }

	    // Get element at index
	    public T get(int index) {
	        checkIndex(index);
	        return (T) elements[index];
	    }

	    // Remove element at index
	    public T remove(int index) {
	        checkIndex(index);
	        T removed = (T) elements[index];

	        // Shift elements left
	        for (int i = index; i < size - 1; i++) {
	            elements[i] = elements[i + 1];
	        }

	        elements[--size] = null; // Clear last element
	        return removed;
	    }

	    // Get current size
	    public int size() {
	        return size;
	    }

	    // Internal: Check index bounds
	    private void checkIndex(int index) {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
	        }
	    }

	    // Internal: Resize if needed
	    private void ensureCapacity() {
	        if (size == elements.length) {
	            int newCapacity = elements.length * 2;
	            Object[] newArray = new Object[newCapacity];
	            System.arraycopy(elements, 0, newArray, 0, elements.length);
	            elements = newArray;
	        }
	    }
	    
	    public static void main(String[] args) {
	        MyArrayList<String> list = new MyArrayList<>();
	        list.add("Apple");
	        list.add("Banana");
	        System.out.println(list.get(0)); // Apple
	        System.out.println("Size: " + list.size()); // 2
	        list.remove(1);
	        System.out.println("Size after removal: " + list.size()); // 1
	    }
	}
