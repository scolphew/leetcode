package lsf._070_climbingStairs;

public class ClimbingStairs {
	
	public int fun(int n){
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
		ClimbingStairs c=new ClimbingStairs();
		System.out.println( c.fun( 6 ) );
	}

}
