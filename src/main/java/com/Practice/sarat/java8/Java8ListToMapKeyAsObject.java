package com.Practice.sarat.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8ListToMapKeyAsObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        List<Student> students = Arrays.asList(
		                new Student(1,"John","Doe"),
		                new Student(2,"Jane","Doe"),
		                new Student(3,"Jack","Doe")
		        );

//		        Map<Object, Student> collect = students.stream()
//		                .collect(Collectors.toMap(x->
//		                        x.getId()+x.getFirstName() , x->x, (x, y) -> x , LinkedHashMap::new));
//		        Student::getId,Function.identity() , (x, y) -> x , LinkedHashMap::new));
		        
		        Map<CompsiteKey, Student> collect = students.stream()
		                .collect(Collectors.toMap(
		                        x->new CompsiteKey(x.getId(),x.getFirstName()),student->student));
		        System.out.println(collect);

		        // Answer I am expecting is Ex: {1johnDoe=[id=1,firstName=John, lastName=Doe]}
		    }

		}



 class Student {
    private long id;
    private String firstName;
    private String lastName;
    
	public Student(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
    
}
 class CompsiteKey{
	    private long id;
	    private String first;
		public CompsiteKey(long id, String first) {
			super();
			this.id = id;
			this.first = first;
		}
		public long getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirst() {
			return first;
		}
		public void setFirst(String first) {
			this.first = first;
		}
		@Override
		public String toString() {
			return "CompsiteKey [id=" + id + ", first=" + first + "]";
		}
	    
		
	    
	}
