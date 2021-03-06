package lsf.java._00_._007_ReverseInteger;

/**
 * int数字反转
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverse(Integer.MIN_VALUE));
		System.out.println(s.reverse(12345));
	}
	public int reverse(int x) {
		int val=0,flag=1;
		if(x<0){
			//System.out.println(x);
			x=-x;flag=-1;
			//System.out.println(x);
		}
		while( x>0 ){
			
			if(val>Integer.MAX_VALUE/10  || (val == Integer.MAX_VALUE/10 &&  x%10 > 8 ) ){
				return 0;
			}
			val=val*10+x%10;
			x/=10;
		}
		return val*flag;
	}
}
