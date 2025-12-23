package com.sarat.logicalInterview;

public class StockBuySell {
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price);   
            System.out.println("----->"+buy1); // First buy
            sell1 = Math.max(sell1, buy1 + price); 
            System.out.println(sell1);// First sell
            buy2 = Math.max(buy2, sell1 - price); 
            System.out.println("======>"+buy2);// Second buy
            sell2 = Math.max(sell2, buy2 + price); 
            System.out.println(sell2);// Second sell
        }

        return sell2;
    }

    // Example usage
    public static void main(String[] args) {
    	StockBuySell sol = new StockBuySell();

        int[] prices1 = {3,3,5,0,0,3,1,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        System.out.println(sol.maxProfit(prices1)); // Output: 6
        System.out.println(sol.maxProfit(prices2)); // Output: 4
        System.out.println(sol.maxProfit(prices3)); // Output: 0
    }

}
