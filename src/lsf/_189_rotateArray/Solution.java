package lsf._189_rotateArray;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] a={-1};
		s.rotate(a, 2);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

//	Rotate an array of n elements to the right by k steps.
//	旋转n个元素向右移k步的阵列。
//	For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//	Note:
//	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//	试着想出尽可能多的解决方案，你可以，至少有3种不同的方法来解决这个问题。
//	[show hint]
//
//	Related problem: Reverse Words in a String II
//
//	Credits:
//	Special thanks to @Freezen for adding this problem and creating all test cases.
	public void rotate(int[] nums, int k) {
		int n=nums.length;
		if(n<2||k <= 0||k==n) return;
		k=k%n;
		int p=n-k;
		reversalArray(nums,0,p-1);
		reversalArray(nums,p,n-1);
		reversalArray(nums,0,n-1);
	}
	/**
	 * 把数组array的值反转
	 */
	private void reversalArray(int[] array,int i,int j) {
		while(i<j){
			int temp=array[i];
			array[i]=array[j];
			array[j]=temp;
			++i;--j;
		}

	}
	
}
