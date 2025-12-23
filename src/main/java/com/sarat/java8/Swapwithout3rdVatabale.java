package com.sarat.java8;

import java.util.function.BiConsumer;

public class Swapwithout3rdVatabale {

	public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println("Before swapping: a = " + a + ", b = " + b);

        BiConsumer<Integer, Integer> swap = (x, y) -> {
            int temp = x;
            x = y;
            y = temp;
            System.out.println("After swapping: a = " + x + ", b = " + y);
        };

        swap.accept(a, b);

        System.out.println("After swapping: a = " + a + ", b = " + b);
    }
}