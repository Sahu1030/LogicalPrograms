package com.Practice.test.enu;

//public class Test {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Beer b=Beer.RC;
//		System.out.println("hello.");
//
//	}
//
//}
//enum Beer{
//KF,KO,RC,FO;
//Beer(){
//System.out.println("Constructor called.");
//}
//}
enum Color {
	BLUE,
	GREEN,
	RED {
		public void info() {
			System.out.println("Dangerous color");
		}
	};

	public void info() {
		System.out.println("Universal color");
	}
}

class Test {
	public static void main(String args[]) {
		Color[] c = Color.values();
		for (Color c1 : c) {
			System.out.println(c1.ordinal()+"----->"+c1);
			c1.info();
		}
	}
}
