package lsf.java._231_PowerofTwo;

@SuppressWarnings({"SameParameterValue", "WeakerAccess"})
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
		return n==1;
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
