package com.sarat.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ThirdRDHeigestjava8 {

	public ThirdRDHeigestjava8() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> numbers2 = Arrays.asList(5, 3, 2, 4, 1,6,7,8,9);
		System.out.println(numbers2);
		// Sort numbers
		System.out.println("==========4th highest ===========");
		Optional<Integer> firstName = numbers2.stream().sorted(Comparator.reverseOrder()).skip(3).findFirst();
		firstName.ifPresent(name -> System.out.println("First name: " + name));
		
		System.out.println("===========4th last==========");
		Optional<Integer> firstName1 = numbers2.stream().sorted().skip(3).findFirst();
		firstName1.ifPresent(name -> System.out.println("First name: " + name));
		
		System.out.println("=====================");
		List<Emp> emp=  Arrays.asList(new Emp("A",1),new Emp("B",4),new Emp("C",2),new Emp("B",3),new Emp("B",5));
		System.out.println("==========2nd highest  sal emp===========");
		Optional<Emp> res=emp.stream().sorted(Comparator.comparing(Emp::getSal).reversed()).skip(1).findFirst();
		res.ifPresent(name -> System.out.println("EMP result name: " + name.getSal()));
		System.out.println("==========2nd last  sal emp===========");
		Optional<Emp> res1=emp.stream().sorted(Comparator.comparing(Emp::getSal)).skip(1).findFirst();
		res1.ifPresent(name -> System.out.println("EMP result name: " + name.getSal()));

		System.out.println("=====================");
		IntStream.range(1, 6).forEach(g->System.out.print(g));
		System.out.println("=====================");
		IntStream.range(1, 6).forEach(i->{
//				IntStream.range(1, i).forEach(g->System.out.print(" "+g));
				IntStream.range((i * (i - 1)) / 2 + 1, (i * (i + 1)) / 2 + 1).forEach(j -> System.out.print(j + " "));
				System.out.println();
						
		});

	}

}

class Emp {
	String name;
	int sal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public Emp(String c, int sal) {
		super();
		this.name = c;
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Emp [name=" + name + ", sal=" + sal + "]";
	}

}