package lsf.java._136_SingleNumbe;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] nums=new int[]{1,2,2,3,3,1,5};
		System.out.println(  s.singleNumber(nums)  );
		System.out.println(s.singleNumber2(nums));
	}

	/**
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		if( nums.length==0 )
			return 0;
		List<Integer> list=new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if( list.contains( nums[i]) ){
				list.remove( new Integer(nums[i]) );
			}
			else
				list.add(nums[i]);
		}
		return list.get(0);
	}
	public int singleNumber2(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[0]=nums[0]^nums[i];
		}
		return nums[0];
	}
}
