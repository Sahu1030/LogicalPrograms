package com.Practice.sarat.java8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Department {
	String deptId;
 
	public Department(String deptId) {
		this.deptId = deptId;
	}
 
	public String getDeptId() {
		return deptId;
	}
 
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + "]";
	}
}
 
class Employe {
	String empId;
	List<Department> departments;
 
	public Employe(String empId, List<Department> departments) {
		this.empId = empId;
		this.departments = departments;
	}
 
	public String getEmpId() {
		return empId;
	}
 
	public List<Department> getDepartments() {
		return departments;
	}
 
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", departments=" + departments + "]";
	}
}
 
public class Java8TestContains {
	public static void main(String[] args) {
		Department a = new Department("a");
		Department b = new Department("b");
		Department c = new Department("c");
 
		Employe e1 = new Employe("e1", List.of(a, b));
		Employe e2 = new Employe("e2", List.of(c, b));
		Employe e3 = new Employe("e3", List.of(c, c));
		Employe e4 = new Employe("e4", List.of(a, b, c));
 
		List<Employe> employees = List.of(e1, e2, e3, e4);
		Set<Department> departments = employees.stream().flatMap(employee -> employee.getDepartments().stream())
				.collect(Collectors.toSet());
 
		Map<Department, List<Employe>> map = 
				departments.stream()
							.collect(Collectors.toMap(
										Function.identity(),
										d -> employees.stream().filter(e -> e.getDepartments().contains(d)).collect(Collectors.toList())
									)
							);
 
		map.entrySet().forEach(System.out::println);
	}
}
