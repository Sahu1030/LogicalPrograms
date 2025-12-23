package com.Practice.sarat.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(282741, "Atjun", "IT"));
		empList.add(new Employee(234364, "Saurabh", "Mechanical"));
		empList.add(new Employee(242741, "Manikandan", "IT"));
		empList.add(new Employee(245564, "Amir", "CompSc"));
		empList.add(new Employee(253455, "Gaurav", "IT"));
		empList.add(new Employee(224343, "Debasis", "CompSc"));
		empList.add(new Employee(215267, "Sambit", "Mechanical"));

//        Map<Department, List<String>> EmpNamesDeptWise = empList.stream().collect(Collectors.groupingBy(Employee1 :: getDept, 
//        		Collectors.mapping(Employee1 :: getEmpName, Collectors.toList())));
//        
		Map<String, List<String>> EmpNamesDeptWise = empList.stream().collect(Collectors.groupingBy(Employee::getDept,
				Collectors.mapping(Employee::getEmpName, Collectors.toList())));
		System.out.println(EmpNamesDeptWise);

		Map<String, Employee> EmpidDeptWise = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(
						Collectors.maxBy((o1, o2) -> o1.getEmpId() - o2.getEmpId()), Optional::get)));
		System.out.println("#####"+EmpidDeptWise);
		
		Map<String, Optional<Employee>> EmpidDeptWise1 = empList.stream().collect(
				Collectors.groupingBy(Employee::getDept, Collectors.minBy(Comparator.comparing(o1 -> o1.getEmpId()))));
		System.out.println(EmpidDeptWise1);

	}

}

class Employee {
	private int empId;
	private String empName;
	private String dept;

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Employee(int empId, String empName, String dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee1 [empId=" + empId + ", empName=" + empName + ", dept=" + dept + "]";
	}

}