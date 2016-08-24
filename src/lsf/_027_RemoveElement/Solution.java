package lsf._027_RemoveElement;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] i={1,2,3,4,5,6,7 };
		int len=s.removeElement(i, 4);
		for (int j = 0; j < len; j++) {
			System.out.print(i[j]+" ");
		}
	}

	public int removeElement(int[] nums, int val) {
		int new_len=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=val  && i!=new_len++ ) {
				nums[new_len-1]=nums[i];
			}
		}
		return new_len;
	}

}
