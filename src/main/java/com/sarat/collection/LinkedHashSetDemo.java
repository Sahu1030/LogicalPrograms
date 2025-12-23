package com.Practice.collection;

import java.util.LinkedHashSet;

class LinkedHashSetDemo {
	public static void main(String[] args) {
		LinkedHashSet h = new LinkedHashSet();
		h.add("Z");
		h.add("B");
		h.add("C");
		h.add("D");
		h.add(null);
		h.add(10);
		System.out.println(h.add("Z"));// false
		System.out.println(h);// [B, C, D, Z, null, 10]
	}
}