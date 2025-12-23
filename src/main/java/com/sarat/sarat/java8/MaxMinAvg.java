package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxMinAvg {
	public static void main(String[] args) {

		Employees e1 = new Employees(1, "Robert", 26500.00, "USA");
		Employees e2 = new Employees(2, "Abraham", 46500.00, "INDIA");
		Employees e3 = new Employees(3, "Ching", 36500.00, "CHINA");
		Employees e4 = new Employees(4, "David", 16500.00, "INDIA");
		Employees e5 = new Employees(5, "Cathy", 25500.00, "USA");

		List<Employees> list = Arrays.asList(e1, e2, e3, e4, e5);

		Optional<Employees> max = list.stream().collect(Collectors.maxBy(Comparator.comparing(e -> e.salary)));

		System.out.println("Max Salary :: " + max.get().salary);

		Optional<Employees> min = list.stream().collect(Collectors.minBy(Comparator.comparing(e -> e.salary)));

		System.out.println("Min Salary :: " + min.get().salary);
		
		Double totalSalary = list.stream().collect(Collectors.summingDouble(e -> e.salary));
		System.out.println("TOTAL SLARY :::"+totalSalary);
		

		Double avgSalary = list.stream().collect(Collectors.averagingDouble(e -> e.salary));
		System.out.println(avgSalary);

		Map<String, List<Employees>> data = list.stream().collect(Collectors.groupingBy(e -> e.country));
		Map<String, Double> averageSalaryByName = list.stream()
	            .collect(Collectors.groupingBy(
	                Employees::getCountry,
	                Collectors.averagingDouble(Employees::getSalary)
	            ));
		System.out.println(data);
		System.out.println(averageSalaryByName);

	}

}

class Employees {
	int id;
	String name;
	double salary;
	String country;

	public Employees(int id, String name, double salary, String country) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.country = country;
	}

	public String getName() { return name; }
	public String getCountry() { return country; }
    public double getSalary() { return salary; }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "=" + name + "=" + salary + "=" + country;
	}
}
