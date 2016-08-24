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
	// дһ���㷨��ȷ��һ�������ǡ����֡���
	//
	// ���ֵı����ͨ�����·���ȷ����
	// ���������������ʼ��������λ����ƽ�����滻����Ŀ�����ظ��ù��̣�ֱ����Ŀ����1�����У�����ͣ������
	// ����ѭ������ֹ����һ�������ڲ�����1.�˹�����1���˺Ž�����Щ���֡�
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
			//����Ѿ�������  ����
			if(set.contains(sum))
				return false;
			set.add(sum);
			s = (new Integer(sum)).toString();
		}
		return true;
	}
}
