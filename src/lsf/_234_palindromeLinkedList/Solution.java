package lsf._234_palindromeLinkedList;

import lsf._000_base.ListNode;

@SuppressWarnings("WeakerAccess")
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = {1,2,1 };

		Solution s = new Solution();
		ListNode head =ListNode.scanf(i);//输入
		s.print(head);//输出
		System.out.println(s.isPalindrome(head));

	}

	public boolean isPalindrome(ListNode head) {
		int len = 0;
		
		@SuppressWarnings("unused")
		boolean returnValue=false;
		
		ListNode p = head;
		/*
		  获得长度
		 */
		while (p != null) {
			p = p.next;
			++len;
		}
		System.out.println("先获得长度为:"+len);                         // T(n)=n
		
		if(len<2)
			return true;
		
		p=head;
		
			System.out.println("这里是偶数");
			int m=1;
			ListNode q=p.next,per;
			
			while (p != null && m<len/2) {              //花了        T(n)=n/2
					per=p;    //逆序
					p=q;
					q=q.next;
					p.next=per;
					m++;
			}
			head.next=null;
			//现在，已经成功的将链表前半部分反转了;
			if(len%2==1){              //长度为奇数
				q=q.next;
			}
			
			while(p!=null){   
				if(p.val==q.val){   //两边扩展  ，若一样 继续       
					q=q.next;
					p=p.next;
				}else{                  //不一样就可以撤了
					return false;          
				}
			}
			return true;            // 出来就对了           T(n)=n/2  

	}


	private void print(ListNode head) {
		ListNode per = head;
		while (per != null) {
			System.out.print(per.val + " ");
			per = per.next;
		}
		System.out.println();
	}
	public boolean isPalindrome2(ListNode root){
		return true;
	}

}
