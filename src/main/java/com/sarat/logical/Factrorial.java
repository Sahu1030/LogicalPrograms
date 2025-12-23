package com.sarat.logical;

public class Factrorial {

	public Factrorial() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Factrorial f=new Factrorial();
	int sum	=f.sum(5);
	System.out.println(sum);

	}
	
	int sum(int num)
	{
		if(num==0 || num==1)
			return 1;
		else
		
		return num*sum(num-1);
		
	}

}
