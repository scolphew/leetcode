package lsf.java._01_._169_MajorityElement;

import java.util.Arrays;

@SuppressWarnings("WeakerAccess")
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int i[] = { 1, 1, 2, 2, 5, 5, 5 };
		System.out.println(s.majorityElement(i));
	}
	
	
	public int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	

	public int majorityElement(int[] nums) {
		MyStack stack=new MyStack();
		for (int i = 0; i < nums.length; i++) {
			if (stack.list==null) {
				stack.push(nums[i]);
			} else {
				if (nums[i] == stack.top())
					stack.push(nums[i]);
				else
					stack.pop();
			}
		}
		return stack.top();
	}

	public int majorityElement2(int[] nums) {
		int stack[] = new int[nums.length / 2 + 1];
		int k = -1;
		for (int i = 0; i < nums.length; i++) {
			if (k == -1) {
				stack[++k] = nums[i];
			} else {
				if (nums[i] == stack[k])
					stack[++k] = nums[i];
				else
					--k;
			}
		}
		return stack[k];
	}
}
class MyStack {
	ListNode list;
	public void push(int x) {
		if(list==null)
			list=new ListNode(x);
		else{
			ListNode p=list;
			list =new ListNode(x);
			list.next=p;
		}
	}

	public void pop() {
		if(list!=null){
			list=list.next;
		}
	}

	public int top() {
		return list.val;
	}
}

class ListNode {
	int val;
	ListNode next;

	public ListNode(int i) {
		val = i;
	}
}
