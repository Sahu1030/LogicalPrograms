package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstDemoJ8 {

	public static void main(String[] args) {

		List<String> javacourses = Arrays.asList("corejava", "advjava", "springboot", "restapi", "microservices");

		javacourses.stream().limit(3).forEach(c -> System.out.println(c));
		System.out.println("========================================");
		javacourses.stream().skip(3).forEach(c -> System.out.println(c));
		System.out.println("=======================");
		List<String> names = Arrays.asList("raja", "rani", "raja", "rani", "guru");
		names.stream().distinct().forEach(name -> System.out.println(name));
		System.out.println("=======================");
		Person p1 = new Person("John", "USA");
		Person p2 = new Person("Steve", "JAPAN");
		Person p3 = new Person("Ashok", "INDIA");
		Person p4 = new Person("Ching", "CHINA");

		List<Person> persons = Arrays.asList(p1, p2, p3, p4);

		boolean status1 = persons.stream().anyMatch(p -> p.country.equals("INDIA"));
		System.out.println("Any Indian Available ? :: " + status1);

		boolean status2 = persons.stream().anyMatch(p -> p.country.equals("CANADA"));
		System.out.println("Any Canadian Available ? :: " + status2);

		boolean status3 = persons.stream().allMatch(p -> p.country.equals("INDIA"));
		System.out.println("All Persons from India ? :: " + status3);

		boolean status4 = persons.stream().noneMatch(p -> p.country.equals("MEXICO"));
		System.out.println("No Persons from Mexico ? :: " + status4);
		List<String> indians = persons.stream().filter(p -> p.country.equals("INDIA")).map(p -> p.name).collect(Collectors.toList());
		System.out.println("********* " + indians);
		indians.forEach(i -> System.out.println(i));

	}
}

class Person {

	String name;
	String country;

	public Person(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"-----"+country;
	}

}
