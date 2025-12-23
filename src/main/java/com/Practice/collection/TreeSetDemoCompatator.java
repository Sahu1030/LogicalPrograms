package com.Practice.collection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemoCompatator {

	public static void main(String[] args) {
		TreeSet t = new TreeSet(new MyComparatorok());
		t.add("Roja");
		t.add("ShobaRani");
		t.add("RajaKumari");
		t.add("GangaBhavani");
		t.add("Ramulamma");
		t.add("Ajay");
		System.out.println(t);// [ShobaRani, Roja, Ramulamma, RajaKumari, GangaBhavani]
	}
}

class MyComparatorok implements Comparator {
	public int compare(Object obj1, Object obj2) {
		String s1 = obj1.toString();
		String s2 = (String) obj2;
		int l1 = s1.length();
		int l2 = s2.length();
		if (l1 < l2)
			return -1;
		else if (l1 > l2)
			return 1;
		else
			return s1.compareTo(s2);
//		return -s1.compareTo(s2);
	}
}
