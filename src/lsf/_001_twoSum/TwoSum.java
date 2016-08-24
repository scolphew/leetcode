package lsf._001_twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int l = nums.length;
		for (int i = 0; i < l; ++i)
			for (int j = i + 1; j < l; ++j)
				if (nums[i] + nums[j] == target) {
					int[] x = { i + 1, j + 1 };
					return x;
				}
		return null;
	}
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> hashtable=new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
				try {
					//如果能在hashtable找到找到另一半，则直接返回
					int [] x={ hashtable.get(target-nums[i]) , i+1};
					return x;
				} catch (Exception e) {
					//如抛出异常，则说明没找到另一半，将当前数存入hashtable
					hashtable.put( nums[i] , i+1);
				}
		}
		return null;
	}
	/**
	 * 遍历数组，每个数查找之前是否遇到过匹配的数
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashtable=new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			//与方法二的区别在于先判断是否在数组中，而不是直接检测
			if( hashtable.containsKey( target-nums[i] )   ){
				int [] x={ hashtable.get(target-nums[i]) , i+1};
				return x;
			}
			hashtable.put( nums[i] , i+1);
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("sss");
	}
}
