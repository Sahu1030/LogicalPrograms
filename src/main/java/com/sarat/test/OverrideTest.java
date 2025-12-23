package com.Practice.test;

public class OverrideTest {

	public OverrideTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Parent();
		p.marry();// subbalakshmi(parent method)
		Child c = new Child();
		c.marry();// Trisha/nayanatara/anushka(child method)
		c.privatemarry();
		c.staticmarry();
		c.methodOne();
		Parent p1 = new Child();
		p1.marry();// Trisha/nayanatara/anushka(child method)
		p1.property();
		p1.methodOne();
		p1.staticmarry();

	}
}

class Parent {
	public void property() {
		System.out.println("cash+land+gold");
	}

	public void marry() {
		System.out.println("subbalakshmi");// overridden method
	}
	private void privatemarry() {
		System.out.println("Parent privatemarry");//canot override 
	}
	static void staticmarry() {
		System.out.println("Parent staticmarry");// overridden method
	}
	public final void methodOne()
	{System.out.println("Parent final method");}
}

class Child extends Parent // overriding
{
	public void marry() {
		System.out.println("Trisha/nayanatara/anushka"); // overriding method
	}
	public void property() {
		System.out.println("child prperty method");
	}
	void privatemarry() {
		System.out.println("privatemarry");// child class private method canot override private method
	}
	static void staticmarry() {
		System.out.println("staticmarry");// can overridden method
	}
//	public void methodOne()//Cannot override the final method from Parent but through child ref we can call
//	{}
}
