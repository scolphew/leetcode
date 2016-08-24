package lsf._231_PowerofTwo;

public class Solution {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(4));
	}
	public static boolean isPowerOfTwo(int n) {
		if(n<=0)
			return false;
		while((n&1)==0){
			n>>>=1;
		}
		System.out.println(n);
		if(n==1)
			return true;
		else 
			return false;
	}
	public static boolean isPowerOfTwo2(int n) {
		if(n<=0)
			return false;
		while((n&1)==0){
			n>>>=1;
		}
		System.out.println(n);
		return n==1;
	}
}
