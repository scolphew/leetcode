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
					//�������hashtable�ҵ��ҵ���һ�룬��ֱ�ӷ���
					int [] x={ hashtable.get(target-nums[i]) , i+1};
					return x;
				} catch (Exception e) {
					//���׳��쳣����˵��û�ҵ���һ�룬����ǰ������hashtable
					hashtable.put( nums[i] , i+1);
				}
		}
		return null;
	}
	/**
	 * �������飬ÿ��������֮ǰ�Ƿ�������ƥ�����
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashtable=new HashMap<Integer,Integer>();
		for (int i = 0; i < nums.length; i++) {
			//�뷽�����������������ж��Ƿ��������У�������ֱ�Ӽ��
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
