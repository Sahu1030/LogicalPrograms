package com.Practice.collection;

import java.util.TreeSet;

class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet t = new TreeSet();
//		t.add(null);// NullPointerException
		t.add("A");
		t.add("a");
		t.add("B");
		t.add("Z");
//		t.add(null);// NullPointerException
		t.add("L");
//		t.add(new Integer(10));// ClassCastException
//		t.add("L");
		System.out.println(t);// [A, B, L, Z, a]
	}
}
