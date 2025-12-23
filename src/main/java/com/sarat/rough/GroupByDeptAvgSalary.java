package com.sarat.rough;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByDeptAvgSalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 5000),
                new Employee("Anna", "HR", 4500),
                new Employee("Mike", "IT", 6000),
                new Employee("Sara", "Finance", 7000),
                new Employee("Tom", "HR", 5500)
        );

        Map<String, Double> deptSalaryTotal = new HashMap<String, Double>();
        Map<String, Integer> deptCount = new HashMap<String, Integer>();

        for (Employee emp : employees) {
            String dept = emp.getDepartment();
            double sal = emp.getSalary();

            // Update total salary
            if (!deptSalaryTotal.containsKey(dept)) {
                deptSalaryTotal.put(dept, sal);
            } else {
                deptSalaryTotal.put(dept, deptSalaryTotal.get(dept) + sal);
            }

            // Update employee count
            if (!deptCount.containsKey(dept)) {
                deptCount.put(dept, 1);
            } else {
                deptCount.put(dept, deptCount.get(dept) + 1);
            }
        }

        // Calculate and print averages
        Map<String, Double> deptAvgSalary = new HashMap<String, Double>();

        for (String dept : deptSalaryTotal.keySet()) {
            double total = deptSalaryTotal.get(dept);
            int count = deptCount.get(dept);
            double avg = total / count;

            deptAvgSalary.put(dept, avg);
        }

        System.out.println("Average Salary by Department:");
        for (Map.Entry<String, Double> entry : deptAvgSalary.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

 class Employee {

    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Setters (optional)
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString() for debug printing
    @Override
    public String toString() {
        return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}


