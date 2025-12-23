package com.Practice.sarat.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8YoungEmp {
	public static void main(String[] args) {

		List<Employee25> Employee25List = new ArrayList<Employee25>();

		Employee25List.add(new Employee25(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
		Employee25List.add(new Employee25(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
		Employee25List.add(new Employee25(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
		Employee25List.add(new Employee25(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
		Employee25List.add(new Employee25(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
		Employee25List.add(new Employee25(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
		Employee25List.add(new Employee25(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
		Employee25List.add(new Employee25(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
		Employee25List.add(new Employee25(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
		Employee25List.add(new Employee25(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5));
		Employee25List.add(new Employee25(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0));
		Employee25List.add(new Employee25(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
		Employee25List.add(new Employee25(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
		Employee25List.add(new Employee25(14, "Buttler", 24, "Male", "Sales", 2017, 10700.5));
		Employee25List.add(new Employee25(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
		Employee25List.add(new Employee25(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0));
		Employee25List.add(new Employee25(17, "Sanvi9", 26, "Female", "Development", 2024, 28900.0));
		Employee25List.add(new Employee25(18, "Sanvi1", 26, "Female", "Development", 2004, 28900.0));

		Optional<Employee25> optional = Employee25List.stream()
				.filter(e -> e.gender.equals("Male") && e.department.equals("Development"))
				.min(Comparator.comparing(e -> e.age));

		if (optional.isPresent()) {
			System.out.println(optional.get());
		}
		Optional<Employee25> optionall = Employee25List.stream()
				.filter(e -> e.gender.equals("Male") && e.department.equals("Development"))
				.max(Comparator.comparing(e -> e.age));

		if (optionall.isPresent()) {
			System.out.println(optionall.get());
		}
		Optional<Employee25> optional1 = Employee25List.stream()
				.collect(Collectors.maxBy(Comparator.comparing(e -> e.yearOfJoining)));

		if (optional1.isPresent()) {
			System.out.println(optional1.get());
		}
		Optional<Employee25> optional11 = Employee25List.stream()
				.collect(Collectors.minBy(Comparator.comparing(e -> e.yearOfJoining)));
		
		if (optional11.isPresent()) {
			System.out.println(optional11.get());
		}

		Map<Object, List<Object>> map = Employee25List.stream().collect(Collectors.groupingBy(Employee25::getGender,
				Collectors.mapping(Employee25::getName, Collectors.toList())));
		System.out.println(map);
		
		List<Employee25> list1=Employee25List.stream().sorted(Comparator.comparing(e->((Employee25) e).getSalary())).collect(Collectors.toList());
		System.out.println(list1);
	}

}

class Employee25 {
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public Employee25(int id, String name, int age, String gender, String department, int yearOfJoining,
			double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee2525 [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", department="
				+ department + ", yearOfJoining=" + yearOfJoining + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	// constructor
	// getters and setters

}
