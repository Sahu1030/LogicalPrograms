package com.sarat.logical;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int num = sc.nextInt();
        int num = 12345;
        int rev = 0;

        while (num != 0) {
            int digit = num % 10;    // Extract last digit
            rev = rev * 10 + digit;  // Add digit to reversed number
            num = num / 10;          // Remove last digit
        }

        System.out.println("Reversed number: " + rev);
    }
}