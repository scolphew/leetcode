package lsf._202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isHappy(2));
		//Set<Integer> set=new HashSet<Integer>();
	}

	// Write an algorithm to determine if a number is "happy".
	//
	// A happy number is a number defined by the following process:
	// Starting with any positive integer, replace the number by the sum of the
	// squares of its digits, and repeat the process until the number equals 1
	// (where it will stay), or it loops endlessly in a cycle which does not
	// include 1. Those numbers for which this process ends in 1 are happy
	// numbers.
	// 写一个算法来确定一个数字是“快乐”。
	//
	// 快乐的编号是通过以下方法确定：
	// 用任意的正整数开始，由它的位数的平方和替换的数目，并重复该过程，直到数目等于1（其中，它将停留），
	// 或它循环无休止地在一个周期内不包括1.此过程在1高兴号结束这些数字。
	public boolean isHappy(int n) {
		int sum = n;
		//System.out.println(sum);
		String s = (new Integer(sum)).toString();
		Set<Integer> set=new HashSet<Integer>();
		while (sum!=1) {
			sum=0;
			for (int i = 0; i < s.length(); i++) {
				sum += Math.pow(s.charAt(i) - '0', 2);
			}
	//		System.out.println(sum);
			//如果已经遇到过  结束
			if(set.contains(sum))
				return false;
			set.add(sum);
			s = (new Integer(sum)).toString();
		}
		return true;
	}
}
