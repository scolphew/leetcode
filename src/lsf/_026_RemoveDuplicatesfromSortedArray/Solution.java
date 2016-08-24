package lsf._026_RemoveDuplicatesfromSortedArray;

public class Solution {
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] nums={};
		int k=s.removeDuplicates(nums);
		for (int i = 0; i < k; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public int removeDuplicates(int[] nums) {
		int i=0;
		for (int j = 1; j < nums.length; j++) {
			if(nums[j]!=nums[i]){
				nums[++i]=nums[j];
			}
		}
		return ++i;
	}
}
