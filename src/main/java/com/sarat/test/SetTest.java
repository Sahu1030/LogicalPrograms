package com.Practice.test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emp e1=new Emp(1, "sarat", 1000);
				Emp e2=new Emp(1, "sarat", 1000);
						Emp e3=new Emp(2, "bharat", 200);
						Set<Emp> set = new HashSet<>();
						set.add(e1);
						set.add(e2);

						set.add(e3);
						System.out.println(set);


	}

}

class Emp{
	public int id;
	public String name;
	public int sal;
	
	Emp(int id, String name , int sal)
	{
		this.id=id;
		this.name=name;
		this.sal=sal;
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

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, sal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return id == other.id && Objects.equals(name, other.name) && sal == other.sal;
	}
	
	
	
}
