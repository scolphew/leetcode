package lsf.java._018_4Sum;

import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // 还是用Set防止重复加入
		quickSort(nums, 0, nums.length - 1);// 排序，不解释
		for (int i = 0; i < nums.length; i++) {
			if(i>0 && nums[i]==nums[i-1])
				continue;
			// 查找i之后的部分中找到3个数，使这四个数的和为target
			List<List<Integer>> listThreeNumber = threeSum2(nums, i + 1,
					nums.length - 1, target - nums[i]);
			for (List<Integer> list : listThreeNumber) {// 把当前的值插到每一个链表头
				list.add(0, nums[i]);
			}
			set.addAll(listThreeNumber);// 把这一部分放到set里
		}
		return new ArrayList<List<Integer>>(set);// 把Set塞进list返回
	}
	
	public List<List<Integer>> fourSum2(int[] nums, int target) {
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // 还是用Set防止重复加入
		quickSort(nums, 0, nums.length - 1);// 排序，不解释
		for (int i = 0; i < nums.length; i++) {
			if(i>0 && nums[i]==nums[i-1])
				continue;
			// 查找i之后的部分中找到3个数，使这四个数的和为target
			List<List<Integer>> listThreeNumber = threeSum2(nums, i + 1,
					nums.length - 1, target - nums[i]);
			for (List<Integer> list : listThreeNumber) {// 把当前的值插到每一个链表头
				list.add(0, nums[i]);
			}
			set.addAll(listThreeNumber);// 把这一部分放到set里
		}
		return new ArrayList<List<Integer>>(set);// 把Set塞进list返回
	}

	/**
	 * 第15题的函数。 直接复制过来的，学长你不用看了
	 * @return
	 */
	public List<List<Integer>> threeSum2(int[] nums, int p, int q, int target) {
		// quickSort(nums, p,q); // 先对数组排序 复杂都O(n)，先排好序再调用 排过序的就免了吧
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // 先使用Set防止重复加入
		for (int i = p; i < q-1 ; i++) { // 对每个数便利，倒数第三个就结束了。
			if(i>p && nums[i]==nums[i-1])
				continue;
			for (int left = i + 1, right = q; left < right;) { // 对之后的数双指针遍历
				if (nums[i] + nums[left] + nums[right] == target) { // 满足条件就可以输出了
					// List<Integer> l = new ArrayList<Integer>(3); //
					// 这时候创建链表，存三个数就行，不用太多。
					List<Integer> l = new ArrayList<Integer>(4);// 求不在加了
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]); // 把三个数存进去
					set.add(l); // 加入总列表
					--right;// 但是，
					++left; // 我们并不能保证唯一，所以
					continue; // 只能跳出当前循环
				}
				if (nums[i] + nums[left] + nums[right] > target)// 如果，和偏大的话
					--right;// 后指针前移
				else
					// 否则
					++left;// 前指针后移
			}
		}
		return new ArrayList<List<Integer>>(set);// 把Set塞进list返回
	}

	/**
	 * 快速排序算法
	 * 
	 * @param nums
	 *            排序数组
	 * @param p
	 *            排序起点
	 * @param q
	 *            排序终点
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
