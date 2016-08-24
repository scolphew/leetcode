package lsf._002_AddTwoNumbers;

import lsf._000_base.ListNode;

@SuppressWarnings("WeakerAccess")
public class Solution {

	public static void main(String[] args) {
		Solution s=new Solution();
		int[] i1={1,2,9};
		int[] i2={9,7};
		ListNode l=s.addTwoNumbers(
					ListNode.scanf(i1),
					ListNode.scanf(i2)
				);
		ListNode.print(l);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode l=l1,per1=null,per2=null;
		int flag=0;
		while(l1!=null && l2!=null){
			l1.val=(l2.val+l1.val+flag);
			flag=l1.val/10;
			l1.val%=10;
			per1=l1;
			l1=l1.next;
			l2=l2.next;
		}
		while(l1!=null){
			l1.val=(l1.val+flag);
			flag=l1.val/10;
			l1.val%=10;
			per1=l1;
			l1=l1.next;
		}
		

		while(l2!=null){
			per2=l2;
			int val=l2.val+flag;
			flag=val/10;
			l2.val=val%10;
			per1.next=l2;
			per1=per1.next;
			l2=l2.next;
			
		}
		if(flag==1){
			if(per2!=null)
				per2.next=new ListNode(1);
			else
				per1.next=new ListNode(1);
		}
		return l;
	}
}
