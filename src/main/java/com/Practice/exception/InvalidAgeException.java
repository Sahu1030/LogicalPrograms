package com.Practice.exception;

public class InvalidAgeException {

    public void registerVoter(int age) throws CustemException {
        if (age < 18) {
            throw new CustemException("Age must be 18 or older to vote.");
        }
        System.out.println("Voter registered successfully.");
    }
}
