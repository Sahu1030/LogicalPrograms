package com.sarat.corejava;

public class ExceptionReturnStatenent {

	public ExceptionReturnStatenent() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("finally")
	static int exeReturn()
	{
		try {
			
			return 1;
		
			
		} catch (Exception e) {
			// TODO: handle exception
			return 2;
			
		}
		finally{
			return 3;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(ExceptionReturnStatenent.exeReturn());
	}
}
