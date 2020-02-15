package lsf.java._00_._015_3Sum;

import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		//List<List<Integer>> list=new ArrayList<List<Integer>>();
		//if(nums.length<3) return list;//呵呵
		Arrays.sort(nums);
		//if(nums[0]>0)return list;//呵呵
		//if(nums[nums.length-1]<0)return list;//呵呵
		List<List<Integer>> set = new LinkedList<List<Integer>>(); // 先试用Set防止重复加入
		for (int i = 0; i < nums.length - 2; i++) { // 对每个数便利，倒数第三个就结束了。
//			if(i>0 && nums[i]==nums[i-1])
//				continue;
			for (int left = i + 1, right = nums.length - 1; left < right;) { // 对之后的数双指针遍历
				if (nums[i] + nums[left] + nums[right] == 0) { // 满足条件就可以输出了
					List<Integer> l = new ArrayList<Integer>(3); // 这时候创建链表，存三个数就行，不用太多。
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]); // 把三个数存进去
					set.add(l); // 加入总列表
					while(left<right&&nums[right]==nums[--right]);
					while(left<right&&nums[left]==nums[++left]);
						
						
//					--right;//但是，
//					++left; //我们并不能保证唯一，所以
					continue; // 只能跳出当前循环
				} if (nums[i] + nums[left] + nums[right] > 0)//如果，和偏大的话
					--right;//后指针前移
				else//否则
					++left;//前指针后移
			}
			while(i<nums.length - 2 && nums[i]==nums[i+1])
				++i;
			if (nums[i] == 0) // 如果当前的数是0的话          
				break;//后面一群正数还有机会吗
		}
		//list=new ArrayList<List<Integer>>(set);
		return set;// 把Set塞进list返回
	}
	
	public List<List<Integer>> threeSum_try(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> set = new LinkedList<List<Integer>>(); 
		for (int i = 0; i < nums.length - 2; i++) {
			for (int left = i + 1, right = nums.length - 1; left < right;) { 
				if (nums[i] + nums[left] + nums[right] == 0) { 
					List<Integer> l = new ArrayList<Integer>(3); 
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]);
					set.add(l);
					while(left<right&&nums[right]==nums[--right]);
					while(left<right&&nums[left]==nums[++left]);
					continue;
				} if (nums[i] + nums[left] + nums[right] > 0)
					--right;
				else
					++left;
			}
			while(i<nums.length - 2 && nums[i]==nums[++i]);
			--i;
			if (nums[i] == 0)       
				break;
		}
		return set;
	}
	
	
	
	/**
	 * 用下面的函数试试
	 * @param nums
	 * @param p
	 * @param q
	 * @param target
	 * @return
	 */
	public List<List<Integer>> threeSum2(int[] nums,int p,int q,int target) {
		quickSort(nums, p,q);//排序先
		return threeSum3(nums,p,q,target);
	}
	/**
	 * 这个函数是给第18题用的，只在nums<p-q>中间查找
	 * @param nums 还是这个数组,不过已经排好序了
	 * @param p 查找部分的起点
	 * @param q 查找部分的终点
	 * @param target 查找和
	 * @return list的list
	 */
	public List<List<Integer>> threeSum3(int[] nums,int p,int q,int target) {
		//quickSort(nums, p,q); // 先对数组排序 复杂都O(n)，先排好序再调用
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // 先使用Set防止重复加入
		for (int i = p; i < q - 1; i++) { // 对每个数便利，倒数第三个就结束了。
			if(i>0 && nums[i]==nums[i]-1)
				break;
			for (int left = i + 1, right = q; left < right;) { // 对之后的数双指针遍历
				if (nums[i] + nums[left] + nums[right] == target) { // 满足条件就可以输出了
					//List<Integer> l = new ArrayList<Integer>(3); // 这时候创建链表，存三个数就行，不用太多。
					List<Integer> l = new ArrayList<Integer>(4);//求不在加了
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]); // 把三个数存进去
					set.add(l); // 加入总列表
					--right;//但是，
					++left; //我们并不能保证唯一，所以
					continue; // 只能跳出当前循环
				} if (nums[i] + nums[left] + nums[right] > target){//如果，和偏大的话
					--right;//后指针前移
				}else//否则
					++left;//前指针后移
			}
//			if (nums[i] > target) // 如果当前的数是target的话       有了负数之后 会出错
//				break;//后面一群数还有机会吗
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
	public static void printListList(List<List<Integer>> list){
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution s = new Solution();

		int[] i = {0,0,0};
		printListList(s.threeSum_try(i));
//		i =new int[]{-1 ,0 ,1, 2 ,-1 ,-4};
//		System.out.println("2");
//		printListList(s.threeSum2(i,0,i.length-1,0));

		
	}
}
