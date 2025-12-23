import java.util.ArrayList;
import java.util.List;

public class Stock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] stock= {3,3,5,0,0,3,1,4};
		
		int maxprofit=0;
		int maxtran=0;
		
		int profit=0;
		
		List<Integer> list=new ArrayList<>();
		
		for(int i=0; i<stock.length; i++){
			
			for(int j=i+1; j<stock.length; j++)
			{
				
				if(stock[j]-stock[i]>maxprofit && maxtran<=2)
				{
					maxprofit=stock[j]-stock[i];
					list.add(maxprofit);
//					maxprofit=maxprofit+maxprofitt;
					maxtran++;
					profit=profit+maxprofit;
				}
				i=j;
				
				
			}
			
		}
		
		System.out.println(profit);
		System.out.println(list);
		
		

	}

}
