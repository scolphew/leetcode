package lsf.java._00_._083_RemoveDuplicatesfromSortedList;

import base.ListNode;

@SuppressWarnings("WeakerAccess")
public class Solution {
	public static void main(String[] args) {
		int i[]={1,1};
		ListNode list=ListNode.scanf(i);
		ListNode.print(list);
		deleteDuplicates(list);
		ListNode.print(list);
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return null;
		ListNode p=head;
		while(p.next!=null){
			if(p.val==p.next.val){
				p.next=p.next.next;
			}else
				p=p.next;
		}
		return head;
	}
	
}
