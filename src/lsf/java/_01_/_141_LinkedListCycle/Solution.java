package lsf.java._01_._141_LinkedListCycle;

import base.ListNode;

@SuppressWarnings("WeakerAccess")
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode h=ListNode.scanf(new int[]{1,2});
		
		System.out.println(  hasCycle(h) );
	}

	public static boolean hasCycle(ListNode head) {
		if(head==null || head.next==null )
			return false;
		if( head.next.next==null)
			return false;
		ListNode p1=head.next;
		ListNode p2=head.next.next;
		
		while(p2!=null&&p2.next!=null && p2.next.next!=null){
			p1=p1.next;
			p2=p2.next.next;
			if(p1==p2)
				return true;
		}
		return false;
			
	}

}
