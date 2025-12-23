package com.Practice.exception;

public class Main {
    public static void main(String[] args) {
    	InvalidAgeException registration = new InvalidAgeException();
        try {
            registration.registerVoter(16);
        } catch (CustemException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }
}

