package lsf._217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		int[] i={1,2,3};
		System.out.println(containsDuplicate(i));
	}
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])){
				return true;
			}else {
				set.add(nums[i]);
			}
		}
		return false;
	}
}
