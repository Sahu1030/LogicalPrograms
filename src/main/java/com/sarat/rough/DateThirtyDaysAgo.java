package com.sarat.rough;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateThirtyDaysAgo {

	public DateThirtyDaysAgo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        
        // Get the date that is 30 days before the current date
        LocalDate dateThirtyDaysAgo = currentDate.minusDays(30);
        
        // Format the dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MMM-yy");
        
        // Print the results
        System.out.println("Current date: " + currentDate.format(formatter));
        System.out.println("Current date: " + currentDate.format(formatter1));
        System.out.println("Date 30 days before current date: " + dateThirtyDaysAgo.format(formatter));
        System.out.println("Date 30 days before current date: " + dateThirtyDaysAgo.format(formatter1));
        System.out.println("Date 30 days before current date: " + dateThirtyDaysAgo.format(formatter2));
    }

}



