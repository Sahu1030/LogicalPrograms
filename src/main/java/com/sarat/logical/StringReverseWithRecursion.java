package com.sarat.logical;

public class StringReverseWithRecursion {

	public StringReverseWithRecursion() {
	}

	// TODO Auto-generated constructor stub
	public static void main(String[] args) {
		String input = "sarat chandra sahu";
		String[] words = input.split(" ");
		String words1=" ";
		String wordsr=" ";
		
		for(int i=0;i<words.length;i++)
		{
			words1 = words[i]+" "+words1;
			System.out.println(words[i]);
			wordsr=wordsr+" "+reverse(words[i]);
		}
		System.out.println(words1);
		System.out.println(wordsr);
		System.out.println("Input was: "+input);
		System.out.println("Reversed: " + reverse(input));
	}

	public static String reverse(String str) {
		if (str.isEmpty())
			return str;
		
//		System.out.println(str.charAt(0));
//		System.out.println(str.substring(1));
		return reverse(str.substring(1)) + str.charAt(0);
		
		
	}
}
