package com.Practice.sarat.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8ListSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<UserL> userList = new ArrayList<>(Arrays.asList(
		        new UserL("Sohn", 33), 
		        new UserL("Robert", 21), 
		        new UserL("Mark", 26), 
		        new UserL("Mark", 17),
		        new UserL("Brandon", 47),
		        new UserL("Ram", 42),
		new UserL("DRamSankar", 42)));
		

		List<UserL> sortedList = userList.stream()
		        .sorted(Comparator.comparing(UserL::getAge))
		        .collect(Collectors.toList());
		System.out.println(sortedList);
		 Map<Integer, List<String>> list = userList.stream()
		        .sorted(Comparator.comparing(UserL::getAge))
		        .collect(Collectors.groupingBy(UserL::getAge, Collectors.mapping(UserL::getName, Collectors.toList())));
		System.out.println("============>"+list);
		UserL maxAgeEmp = userList.stream()
	            .collect(Collectors.minBy(Comparator.comparing(UserL::getAge))).get();
//		.collect(Collectors.maxBy(Comparator.comparing(userL->userL.getAge()))).get();
		UserL maxAge3Emp = userList.stream().map(a->a).sorted(Comparator.comparing(UserL::getAge))
				.skip(2).findFirst().get();
	            
		System.out.println(maxAgeEmp  +"=========="+ maxAge3Emp);

	}

}

class UserL {

	private String name;
	private int age;

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

	public UserL(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

	// Constructor, getters, setters and toString()

}
