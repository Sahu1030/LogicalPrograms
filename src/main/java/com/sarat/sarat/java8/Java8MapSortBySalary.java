package com.Practice.sarat.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8MapSortBySalary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map2 = new HashMap<>();
        map2.put("anil",1000);
        map2.put("ankit",1200);
        map2.put("bhavna",1200);
        map2.put("james",1200);
        map2.put("micael",1000);
        map2.put("tom",1300);
        map2.put("daniel",1300);
        
        Map.Entry<Integer,List<String>> finalResult2 = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry ->entry.getValue(),
                                Collectors.mapping(entry -> entry.getKey(),Collectors.toList())
                                ))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(it -> it.getKey()))
                .collect(Collectors.toList())
                .get(2);//1300
        System.out.println(finalResult2);
		
		Map<Integer,Employee1> map = new HashMap<>();
		map.put(1,new Employee1(101, "siva", 2000));
		map.put(2,new Employee1(102, "Ram", 3000));
		map.put(3,new Employee1(103, "Brhama", 4000));

		System.out.println(map.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue())));
//		map.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));

	}

}

class Employee1 {

    private int empId;
    private String empName;
    private int empSalary;
    
	public Employee1(int empId, String empName, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public Object stream() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + "]";
	}
    
}
