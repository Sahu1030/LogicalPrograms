
public class CountCheck {

	private static int data =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountCheck c=new CountCheck();
		
//		if(data <=1)
//		check();
//
//		if(data==1)
//		{
//			
//			System.out.println("inside1");
//			check();
//		}
		check();

	}
	
	
	 static void check() {
		if(data<1)
		{
			System.out.println("inside 0 ..");
			
		}
			if(data ==1)
			{
				System.out.println("inside 1..");
			}
			if(data >1)
			{
				System.out.println("Break");
				return;
			}
			data++;
			check();
			data=0;
		
//		return this.data++;
	}
}
