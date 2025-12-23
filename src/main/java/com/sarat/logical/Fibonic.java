package com.sarat.logical;

//public class Fibonic {
//
//	public Fibonic() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public static void main(String[] args) {
//        int count = 10;
//        int a = 0, b = 1;
//
//        System.out.print("Fibonacci Series: " + a + " " + b);
//
//        for (int i = 2; i < count; i++) {
//            int next = a + b;
//            System.out.print(" " + next);
//            a = b;
//            b = next;
//        }
//    }
//	
//	
//}

public class Fibonic {
    public static void main(String[] args) {
        int count = 10;
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

