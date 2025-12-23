package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EMPSalCountDeptWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employees1s e1 = new Employees1s(1, "Robert", 26500.00, "USA", "MALE");
		Employees1s e2 = new Employees1s(2, "Abraham", 46500.00, "INDIA", "FEMALE");
		Employees1s e3 = new Employees1s(3, "Ching", 36500.00, "CHINA", "MALE");
		Employees1s e4 = new Employees1s(4, "David", 16500.00, "INDIA", "FEMALE");
		Employees1s e5 = new Employees1s(5, "Cathy", 25500.00, "USA", "MALE");
		Employees1s e6 = new Employees1s(6, "Cathy", 25500.00, "OMAN", "FEMALE");
		Employees1s e7 = new Employees1s(7, "Cathy", 17500.00, "INDIA", "MALE");
		Employees1s e8 = new Employees1s(8, "Bulu", 55000.00, "INDIA", "MALE");

		List<Employees1s> list = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8);
		DoubleSummaryStatistics sum = list.stream().collect(Collectors.summarizingDouble(e -> e.salary));
		System.out.println("=======>"+sum);
		Optional<Employees1s> optional1 = list.stream()
				.filter(e -> e.gender.equals("MALE") && e.country.equals("INDIA"))
				.collect(Collectors.minBy(Comparator.comparing(e -> e.salary)));

		if (optional1.isPresent()) {
			Employees1s employee = optional1.get();
			System.out.println(employee.salary);

		}
		Optional<Employees1s> optional = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)));

		if (optional.isPresent()) {
			Employees1s employee = optional.get();
			System.out.println(employee);
		}

		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(e -> e.country, Collectors.counting()));
		System.out.println(map);
		Map<String, List<Employees1s>> mapp1 = list.stream().collect(Collectors.groupingBy(e -> e.country));
		System.out.println("&&&&&&&======>"+mapp1);
		Map<String, Double> map1 = list.stream()
//				.filter(e -> e.gender.equals("MALE") && e.country.equals("INDIA"))
				.collect(Collectors.groupingBy(e -> e.country, Collectors.averagingDouble(e -> e.salary)));
		System.out.println("*************************"+map1);
		Map<String, Double> map2 = list.stream()
				.collect(Collectors.groupingBy(e -> e.country, Collectors.summingDouble(e -> e.salary)));
		System.out.println(map2);
		Map<String, Long> map3 = list.stream().filter(e -> e.country.equals("INDIA"))
				.collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));
		System.out.println(map3);

		Map<String, Optional<Employees1s>> mappp = list.stream()
				.collect(Collectors.groupingBy(e -> e.country, Collectors.minBy(Comparator.comparing(e->e.salary))));
		System.out.println("====================="+mappp);
		Map<String, List<Employees1s>> listEmp = list.stream()
				.collect(Collectors.groupingBy(e -> e.country));
		
		System.out.println("==========List OF Employee BAsed on Country==========="+listEmp);
		Map<String, List<Double>> mapp = list.stream()
				.collect(Collectors.groupingBy(e -> e.country, Collectors.mapping(e -> e.salary, Collectors.toList())));
		System.out.println(mapp);

		Map<String, List<String>> allname = list.stream()
				.collect(Collectors.groupingBy(e -> e.country, Collectors.mapping(e -> e.name, Collectors.toList())));
		System.out.println(allname);
		System.out.println("==============================");
		list.stream()
				.collect(
						Collectors.groupingBy(e -> e.country,
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)), Optional::get)))
				.forEach((k, v) -> System.out.println(k + ":" + v));
		System.out.println("==============================");
		
		list.stream()
		.map(e->e.country)
//		.distinct().collect(Collectors.toList()); //or
		.distinct()
		.forEach(name -> System.out.println(name));


	}

	private static Object comparingDouble(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}

class Employees1s {
	int id;
	String name;
	double salary;
	String country;
	String gender;

	public Employees1s(int id, String name, double salary, String country, String gender) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.country = country;
		this.gender = gender;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "=" + name + "=" + salary + "=" + country + "=" + gender;
	}
}