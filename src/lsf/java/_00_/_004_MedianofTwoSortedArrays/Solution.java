package lsf.java._00_._004_MedianofTwoSortedArrays;

/**
 * 返回两个排序的数组合并之后的中位数
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i[]={1,2,3,4,8,9};
		int j[]={6,6,7,8,10,69};
		Solution s=new Solution();
		System.out.println(s.findMedianSortedArrays(i,j));
	}

	/**
	 * 返回numbers1从start1开始，numbers2从start2开始的合并数组第k大的数字
	 * @return
	 */
	public double helper(int[] numbers1, int start1, int[] numbers2, int start2, int topK){
		if(start1 > numbers1.length-1) return numbers2[start2+topK-1];
		if(start2 > numbers2.length-1) return numbers1[start1+topK-1];
		if(topK == 1) return Math.min(numbers1[start1], numbers2[start2]);

		if(start2+topK/2-1 > numbers2.length-1) return helper(numbers1,start1+topK/2,numbers2,start2,topK-topK/2);
		if(start1+topK/2-1 > numbers1.length-1) return helper(numbers1,start1,numbers2,start2+topK/2,topK-topK/2);

		if(numbers1[start1+topK/2-1] < numbers2[start2+topK/2-1])
			return helper(numbers1,start1+topK/2,numbers2,start2,topK-topK/2);
		else
			return helper(numbers1,start1,numbers2,start2+topK/2,topK-topK/2);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2 ){
		int leftMedian = (nums1.length+nums2.length+1)/2;
		int rightMedian = (nums1.length+nums2.length+2)/2;
		return (helper(nums1,0,nums2,0,leftMedian)+helper(nums1,0,nums2,0,rightMedian))/2.0;
	}
}
