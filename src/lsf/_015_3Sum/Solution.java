package lsf._015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lsf._000_base.Print;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		//List<List<Integer>> list=new ArrayList<List<Integer>>();
		//if(nums.length<3) return list;//�Ǻ�
		Arrays.sort(nums);
		//if(nums[0]>0)return list;//�Ǻ�
		//if(nums[nums.length-1]<0)return list;//�Ǻ�
		List<List<Integer>> set = new LinkedList<List<Integer>>(); // ������Set��ֹ�ظ�����
		for (int i = 0; i < nums.length - 2; i++) { // ��ÿ���������������������ͽ����ˡ�
//			if(i>0 && nums[i]==nums[i-1])
//				continue;
			for (int left = i + 1, right = nums.length - 1; left < right;) { // ��֮�����˫ָ�����
				if (nums[i] + nums[left] + nums[right] == 0) { // ���������Ϳ��������
					List<Integer> l = new ArrayList<Integer>(3); // ��ʱ�򴴽����������������У�����̫�ࡣ
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]); // �����������ȥ
					set.add(l); // �������б�
					while(left<right&&nums[right]==nums[--right]);
					while(left<right&&nums[left]==nums[++left]);
						
						
//					--right;//���ǣ�
//					++left; //���ǲ����ܱ�֤Ψһ������
					continue; // ֻ��������ǰѭ��
				} if (nums[i] + nums[left] + nums[right] > 0)//�������ƫ��Ļ�
					--right;//��ָ��ǰ��
				else//����
					++left;//ǰָ�����
			}
			while(i<nums.length - 2 && nums[i]==nums[i+1])
				++i;
			if (nums[i] == 0) // �����ǰ������0�Ļ�          
				break;//����һȺ�������л�����
		}
		//list=new ArrayList<List<Integer>>(set);
		return set;// ��Set����list����
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
	 * ������ĺ�������
	 * @param nums
	 * @param p
	 * @param q
	 * @param target
	 * @return
	 */
	public List<List<Integer>> threeSum2(int[] nums,int p,int q,int target) {
		quickSort(nums, p,q);//������
		return threeSum3(nums,p,q,target);
	}
	/**
	 * ��������Ǹ���18���õģ�ֻ��nums<p-q>�м����
	 * @param nums �����������,�����Ѿ��ź�����
	 * @param p ���Ҳ��ֵ����
	 * @param q ���Ҳ��ֵ��յ�
	 * @param target ���Һ�
	 * @return list��list
	 */
	public List<List<Integer>> threeSum3(int[] nums,int p,int q,int target) {
		//quickSort(nums, p,q); // �ȶ��������� ���Ӷ�O(n)�����ź����ٵ���
		Set<List<Integer>> set = new HashSet<List<Integer>>(); // ��ʹ��Set��ֹ�ظ�����
		for (int i = p; i < q - 1; i++) { // ��ÿ���������������������ͽ����ˡ�
			if(i>0 && nums[i]==nums[i]-1)
				break;
			for (int left = i + 1, right = q; left < right;) { // ��֮�����˫ָ�����
				if (nums[i] + nums[left] + nums[right] == target) { // ���������Ϳ��������
					//List<Integer> l = new ArrayList<Integer>(3); // ��ʱ�򴴽����������������У�����̫�ࡣ
					List<Integer> l = new ArrayList<Integer>(4);//���ڼ���
					l.add(nums[i]);
					l.add(nums[left]);
					l.add(nums[right]); // �����������ȥ
					set.add(l); // �������б�
					--right;//���ǣ�
					++left; //���ǲ����ܱ�֤Ψһ������
					continue; // ֻ��������ǰѭ��
				} if (nums[i] + nums[left] + nums[right] > target){//�������ƫ��Ļ�
					--right;//��ָ��ǰ��
				}else//����
					++left;//ǰָ�����
			}
//			if (nums[i] > target) // �����ǰ������target�Ļ�       ���˸���֮�� �����
//				break;//����һȺ�����л�����
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
