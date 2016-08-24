package lsf._191_numberOf1Bits;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hammingWeight2(-2147483648));
		System.out.println(s.hammingWeight( -2147483648 ) );
		
		System.out.println( (int)2147483649l) ;
	}
	/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
写一个函数，它的无符号整数并返回它具有“1”的位（也被称为汉明权重）的数量。

例如，32位整数'11'具有二进制表示00000000000000000000000000001011，因此函数应该返回3。

积分：
特别感谢@ts添加这个问题，创建所有的测试用例。
	 */
	public int hammingWeight(int n) {
		int i=0;
		while(n!=0){
			i+=n&1 ;
			n>>>=1;
		}
		return i;
	}
	public int hammingWeight2(int n) {
		int i=0;
		char[] x=Integer.toBinaryString(n).toCharArray();
		for (int j = 0; j < x.length; j++) {
			if(x[i]=='1')
				i++;
		}
		return i;
	}
}
