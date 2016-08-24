package lsf._121_BestTimetoBuyandSellStock;

@SuppressWarnings("WeakerAccess")
public class Solution {
	public static int maxProfit(int[] prices) {
		int max=0,sum=0;
		for (int i = 1; i < prices.length; i++) {
			sum+=prices[i]-prices[i-1];
			if(sum<0) sum=0; 
			if(sum>max) max=sum;
		}
		return max;
		
	}
}
