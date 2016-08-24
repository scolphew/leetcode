package lsf._018_4Sum;

import java.util.*;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // ������Set��ֹ�ظ�����
		quickSort(nums, 0, nums.length - 1);// ���򣬲�����
		for (int i = 0; i < nums.length; i++) {
			if(i>0 && nums[i]==nums[i-1])
				continue;
			// ����i֮��Ĳ������ҵ�3������ʹ���ĸ����ĺ�Ϊtarget
			List<List<Integer>> listThreeNumber = threeSum2(nums, i + 1,
					nums.length - 1, target - nums[i]);
			for (List<Integer> list : listThreeNumber) {// �ѵ�ǰ��ֵ�嵽ÿһ������ͷ
				list.add(0, nums[i]);
			}
			set.addAll(listThreeNumber);// ����һ���ַŵ�set��
		}
		return new ArrayList<List<Integer>>(set);// ��Set����list����
	}
	
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // ������Set��ֹ�ظ�����
		quickSort(nums, 0, nums.length - 1);// ���򣬲�����
		for (int i = 0; i < nums.length; i++) {
			if(i>0 && nums[i]==nums[i-1])
				continue;
			// ����i֮��Ĳ������ҵ�3������ʹ���ĸ����ĺ�Ϊtarget
			List<List<Integer>> listThreeNumber = threeSum2(nums, i + 1,
					nums.length - 1, target - nums[i]);
			for (List<Integer> list : listThreeNumber) {// �ѵ�ǰ��ֵ�嵽ÿһ������ͷ
				list.add(0, nums[i]);
			}
			set.addAll(listThreeNumber);// ����һ���ַŵ�set��
		}
		return new ArrayList<List<Integer>>(set);// ��Set����list����
	}

	/**
	 * ��15��ĺ����� ֱ�Ӹ��ƹ����ģ�ѧ���㲻�ÿ���
	 * @return
	 */
	public List<List<Integer>> threeSum2(int[] nums, int p, int q, int target) {
		// quickSort(nums, p,q); // �ȶ��������� ���Ӷ�O(n)�����ź����ٵ��� �Ź���ľ����˰�
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // ��ʹ��Set��ֹ�ظ�����
		for (int i = p; i < q-1 ; i++) { // ��ÿ���������������������ͽ����ˡ�
			if(i>p && nums[i]==nums[i-1])
				continue;
			for (int left = i + 1, right = q; left < right;) { // ��֮�����˫ָ�����
				if (nums[i] + nums[left] + nums[right] == target) { // ���������Ϳ��������
					// List<Integer> l = new ArrayList<Integer>(3); //
					// ��ʱ�򴴽����������������У�����̫�ࡣ
					List<Integer> l = new ArrayList<Integer>(4);// ���ڼ���
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]); // �����������ȥ
					set.add(l); // �������б�
					--right;// ���ǣ�
					++left; // ���ǲ����ܱ�֤Ψһ������
					continue; // ֻ��������ǰѭ��
				}
				if (nums[i] + nums[left] + nums[right] > target)// �������ƫ��Ļ�
					--right;// ��ָ��ǰ��
				else
					// ����
					++left;// ǰָ�����
			}
		}
		return new ArrayList<List<Integer>>(set);// ��Set����list����
	}

	/**
	 * ���������㷨
	 * 
	 * @param nums
	 *            ��������
	 * @param p
	 *            �������
	 * @param q
	 *            �����յ�
	 */
	public void quickSort(int[] nums, int p, int q) {
		if (q <= p)
			return;
		int x = nums[p];
		int i = p, j = q;
		while (i < j) {
			while (i < j && nums[j] >= x)
				--j;
			nums[i] = nums[j];
			while (i < j && nums[i] <= x)
				++i;
			nums[j] = nums[i];
		}
		nums[i] = x;
		quickSort(nums, p, i - 1);
		quickSort(nums, i + 1, q);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] nums = { -9,-8,-7,-6,-5,9,8,7,6,5,0};
//		Print.printListList(s.fourSum(nums, 0));
		
		
		
		int[] nums = { -491,-489,-470,-428,-416,-413,-394,
				-394, -328, 223, 499,
				-390,-377,-373,-362,-357,-349,-328,-282,-270,
				-266,-247,-175,-156,-133,-122,-116,-102,-91,
				-57,-44,-42,-37,-24,-2,20,42,55,58,71,123,136,
				139,151,155,164,165,193,212,223,294,299,309,313,
				318,327,341,357,374,375,390,392,413,427,453,
				457,459,466,497,499};
		
		
		long time1=(new Date()).getTime();
		for (int i = 0; i < 999999; i++) {
			//System.out.println(s.fourSum(nums, -3742));
			s.fourSum(nums, -3742);
		}
		
		long time2=(new Date()).getTime();
		System.out.println(time2-time1);
		
		
//		int[] nums =new int[] { -1,0,1,2,-1};
//		s.quickSort(nums, 0, 4);
//		System.out.println(s.threeSum2(nums,0,4, 3));
	}
}
