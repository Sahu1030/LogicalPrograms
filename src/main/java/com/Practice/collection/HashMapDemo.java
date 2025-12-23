package com.Practice.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap m = new HashMap();
		m.put(null, 700);
		m.put("chiranjeevi", 700);
		m.put("balaiah", 800);
		m.put("venkatesh", 200);
		m.put("nagarjuna", 500);
//		m.put(null, 800);
		System.out.println(m);// {nagarjuna=500, venkatesh=200,
								// balaiah=800,chiranjeevi=700}System.out.println(m.put("chiranjeevi",100));//
								// 700

		Set s = m.keySet();
		System.out.println(s);// [nagarjuna, venkatesh, balaiah, chiranjeevi]
		Collection c = m.values();
		System.out.println(c);// [500, 200, 800, 100]
		Set s1 = m.entrySet();
		System.out.println(s1);// [nagarjuna=500, venkatesh=200, balaiah=800, chiranjeevi=100]
		Iterator itr = s1.iterator();
		while (itr.hasNext()) {
			Map.Entry m1 = (Map.Entry) itr.next();
			System.out.println(m1.getKey() + "......" + m1.getValue());// nagarjuna......500
			// venkatesh......200//balaiah......800 			// chiranjeevi......100
			if (m1.getKey().equals("nagarjuna")) {
				m1.setValue(1000);
			}
		}
		System.out.println(m);// {nagarjuna=1000, venkatesh=200, balaiah=800, chiranjeevi=100
	}
}
