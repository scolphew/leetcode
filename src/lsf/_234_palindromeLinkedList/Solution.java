package lsf._234_palindromeLinkedList;

import lsf._000_base.ListNode;

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] i = {1,2,1 };

		Solution s = new Solution();
		ListNode head =s.scanf(i);//����
		s.print(head);//���
		System.out.println(s.isPalindrome(head));

	}

	public boolean isPalindrome(ListNode head) {
		int len = 0;
		
		@SuppressWarnings("unused")
		boolean returnValue=false;
		
		ListNode p = head;
		/**
		 * ��ó���
		 */
		while (p != null) {
			p = p.next;
			++len;
		}
		System.out.println("�Ȼ�ó���Ϊ:"+len);                         // T(n)=n
		
		if(len<2)
			return true;
		
		p=head;
		
			System.out.println("������ż��");
			int m=1;
			ListNode q=p.next,per=null;
			
			@SuppressWarnings("unused")
			ListNode sco_text=null;
			
			while (p != null && m<len/2) {              //����        T(n)=n/2
					per=p;    //����
					p=q;
					q=q.next;
					p.next=per;
					m++;
			}
			head.next=null;
			//���ڣ��Ѿ��ɹ��Ľ�����ǰ�벿�ַ�ת��;
			if(len%2==1){              //����Ϊ����
				q=q.next;
			}
			
			while(p!=null){   
				if(p.val==q.val){   //������չ  ����һ�� ����       
					q=q.next;
					p=p.next;
				}else{                  //��һ���Ϳ��Գ���
					return false;          
				}
			}
			return true;            // �����Ͷ���           T(n)=n/2  

	}

	private ListNode scanf(int[] i) {
		if(i.length==0)
			return null;
		ListNode head = new ListNode(i[0]);
		ListNode per = head;
		for (int j = 1; j < i.length; j++) {
			ListNode x = new ListNode(i[j]);
			per.next = x;
			per = x;
		}
		return head;
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
