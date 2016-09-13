package lsf._000_base;

import java.util.List;

public class Print {
	public static void printList(List list){
		for (Object o : list) {
			System.out.print(o+" ");
		}
		System.out.println();
	}
	
	public static void print(int[] nums){
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	
	public static void print(int[] nums,int l,int r){
		for (int i = l; i <= r; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}
	
	public static void printListList(List<List<Integer>> list){
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}

}
