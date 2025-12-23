package com.sarat.DS;

import java.util.ArrayList;

public class HashMap {
	private int size = 10;
	private Node[] dataMap;

	class Node {
		String key;
		int value;
		Node next;

		Node(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public HashMap() {
		dataMap = new Node[size];
	}

	public void printTable() {
		for (int i = 0; i < dataMap.length; i++) {
			System.out.println(i + ":");
			Node temp = dataMap[i];
			while (temp != null) {
				System.out.println("   {" + temp.key + "= " + temp.value + "}");
				temp = temp.next;
			}
		}
	}

	private int hash(String key) {
		int hash = 0;
		char[] keyChars = key.toCharArray();
		for (int i = 0; i < keyChars.length; i++) {
			int asciiValue = keyChars[i];
			System.out.println(asciiValue);
			hash = (hash + asciiValue * 23) % dataMap.length;
		}
		return hash;
	}

	public void set(String key, int value) {
		int index = hash(key);
		Node newNode = new Node(key, value);
		if (dataMap[index] == null) {
			dataMap[index] = newNode;
		} else {
			Node temp = dataMap[index];
			/*
			 * if (temp.key == key) { temp.value += value; return; }
			 */
			while (temp.next != null) {
				temp = temp.next;
				if (temp.key == key) {
					temp.value += value;
					return;
				}
			}
			temp.next = newNode;
		}
	}

	public int get(String key) {
		int index = hash(key);
		Node temp = dataMap[index];
		while (temp != null) {
			if (temp.key == key)
				return temp.value;
			temp = temp.next;
		}
		return 0;
	}

	public ArrayList keys() {
		ArrayList<String> allKeys = new ArrayList<>();
		for (int i = 0; i < dataMap.length; i++) {
			Node temp = dataMap[i];
			while (temp != null) {
				allKeys.add(temp.key);
				temp = temp.next;
			}
		}
		return allKeys;
	}

	public static void main(String[] args) {

		HashMap myHashTable = new HashMap();

		myHashTable.set("nails", 100);
		myHashTable.set("tile", 50);
		myHashTable.set("lumber", 80);
		myHashTable.set("bolts", 200);
		myHashTable.set("screws", 140);
		myHashTable.set("S", 140);

		myHashTable.printTable();

		System.out.println(myHashTable.get("lumber"));

		System.out.println(myHashTable.keys());

	}

}
