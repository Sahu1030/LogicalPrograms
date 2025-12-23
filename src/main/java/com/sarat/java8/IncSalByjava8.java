package com.sarat.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class IncSalByjava8 {

	public IncSalByjava8() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<MyKey> key=new ArrayList<>();
		key.add(new MyKey("sarat",100,"A"));
		key.add(new MyKey("bharat",200,"A"));
		key.add(new MyKey("ram",500,"B"));
		key.add(new MyKey("ram",100,"c"));
		key.add(new MyKey("ram",1000,"c"));

		
		
//		List<MyKey> list = key.stream()
//		        .filter(n -> n.getGrade().equals("A") || n.getGrade().equals("B"))
//		        .map(n -> new MyKey(n.getName(), (int) (n.getSal() * 1.1), n.getGrade()))
//		        .collect(Collectors.toList());
//		System.out.println(list);
		

		/*
		 * // Create a map for grade multipliers
		 */      
//		Map<String, Double> gradeMultipliers = Map.of("A", 1.1, "B", 1.5);//In java 9
//		List<String> supportedCurrencies = List.of("USD", "EUR", "JPY");//In java 9
		Map<String, Double> gradeMultipliers = new HashMap<>();
        gradeMultipliers.put("A", 1.1);
        gradeMultipliers.put("B", 1.5);
        gradeMultipliers.put("c", 1.08);
		List<MyKey> list = key.stream()
		        .map(n -> new MyKey(n.getName(), (int) (n.getSal() * gradeMultipliers.get(n.getGrade())), n.getGrade()))
		        .collect(Collectors.toList());
        System.out.println(list);
        
		/* For Only Salary print */
		 key.stream().peek(n->n.getSal())
				.map(n ->  (int) (n.getSal() * gradeMultipliers.get(n.getGrade())))
				 .forEach(System.out::println); 
		 
		 List<Integer> lis1t= key.stream()
					.map(n ->  (int) (n.getSal() * gradeMultipliers.get(n.getGrade()))).collect(Collectors.toList());
					 System.out.println(lis1t);
	}

}

class MyKey {
	private String name;

	private double sal;
	private String grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public MyKey(String name, double sal, String grade) {
		super();
		this.name = name;
		this.sal = sal;
		this.grade = grade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(grade, name, sal);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyKey other = (MyKey) obj;
		return Objects.equals(grade, other.grade) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(sal) == Double.doubleToLongBits(other.sal);
	}
	@Override
	public String toString() {
		return "MyKey [name=" + name + ", sal=" + sal + ", grade=" + grade + "]";
	}
	
	
	

}
