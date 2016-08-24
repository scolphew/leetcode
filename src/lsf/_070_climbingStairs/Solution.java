package lsf._070_climbingStairs;

public class Solution {
	
	public int climbingStairs(int n){
		int a=2,b=1;
		if(n==1) return 1;
		if(n==2) return 2;
		for (int i = 3; i <=n; i++) {
			a=a+b;
			b=a-b;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Solution c=new Solution();
		System.out.println( c.climbingStairs( 6 ) );
	}

}
