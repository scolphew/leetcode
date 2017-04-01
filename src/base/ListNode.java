package base;

public class ListNode {
	
	public int val;
	
	public ListNode next;
	private ListNode(){}
	public ListNode(int x) {
		val = x;
	}
	

	public static ListNode scanf(int[] i) {
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

	public static void print(ListNode head) {
		ListNode per = head;
		while (per != null) {
			System.out.print(per.val + " ");
			per = per.next;
		}
		System.out.println();
	}

	@Override
	public String toString() {
		StringBuilder sb =new StringBuilder();
		ListNode per = this;
		while (per != null) {
            sb.append(per.val+"   ");
			per = per.next;
		}
		return sb.toString();
	}
}
