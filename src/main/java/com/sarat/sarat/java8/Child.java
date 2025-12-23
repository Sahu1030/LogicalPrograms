package com.Practice.sarat.java8;

public class Child extends Parent {
	 
	
	public static void main(String[] args) {
//			Child c=new Child();
//			Child c1=new Child(2);
//			c.print(1);
		System.out.println("======================");
			Parent cc=new Child();
//			c.print(1);
//			Parent p=new Parent();
//			p.print(1);
//			p.show(1);
			System.out.println("======================");

			Parent pa=new Parent();
//			pa.show();
			
			 Parent.a=111;
			 System.out.println( Parent.a);

	}
	static {
		System.out.println("Child Static block..");
	}
	{
		System.out.println("Child Instance block..");
	}
	public Child(int a) {
		this();
		System.out.println("Child Constructer1");
	}
		public Child() {
		super();
		System.out.println("Child Constructer");
	}
		public static void StatMethod() {
			System.out.println("child Static  method..");
			
		}

	public String show(String string) {
		System.out.println("Instance method..");
		return "Child Sarat.";

	}
	public void show() {
		System.out.println(" Child Instance method..");
		
	}
	public static int print(int a) {
        System.out.println("here child paramenter - Integer");
        return 0;
    }
}
