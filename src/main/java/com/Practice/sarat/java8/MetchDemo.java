package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Arrays;

public class MetchDemo {

	public static void main(String[] args) {

		Personnn p1 = new Personnn("John", "USA");
		Personnn p2 = new Personnn("Steve", "JAPAN");
		Personnn p3 = new Personnn("Ashok", "INDIA");
		Personnn p4 = new Personnn("Ching", "CHINA");
		Personnn p5 = new Personnn("Kumar", "INDIA");

		List<Personnn> Personnns = Arrays.asList(p1, p2, p3, p4, p5);

		List<Personnn> indians = Personnns.stream().filter(p -> p.country.equals("INDIA")).collect(Collectors.toList());

		indians.forEach(i -> System.out.println(i));
		List<String> names = Personnns.stream().filter(p -> p.country.equals("INDIA")).map(p -> p.name)
				.collect(Collectors.toList());
		System.out.println(names);

		List<Personnn> persons = Arrays.asList(p1, p2, p3, p4);

		boolean status1 = persons.stream().anyMatch(p -> p.country.equals("INDIA"));
		System.out.println("Any Indian Available ? :: " + status1);

		boolean status2 = persons.stream().anyMatch(p -> p.country.equals("CANADA"));
		System.out.println("Any Canadian Available ? :: " + status2);

		boolean status3 = persons.stream().allMatch(p -> p.country.equals("INDIA"));
		System.out.println("All Persons from India ? :: " + status3);

		boolean status4 = persons.stream().noneMatch(p -> p.country.equals("MEXICO"));
		System.out.println("No Persons from Mexico ? :: " + status4);

	}
}

class Personnn {

	String name;
	String country;

	public Personnn(String name, String country) {
		this.name = name;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Personnn [name=" + name + ", country=" + country + "]";
	}

}
