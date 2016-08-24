package lsf._155_MinStack;


public class MinStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack stack=new MinStack();
		stack.push(-3);
		stack.getMin();

	}
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

	public int getMin() {
		ListNode p=list;
		int min=Integer.MAX_VALUE;
		while (p!=null) {
			if(p.val<min)
				min=p.val;
			p=p.next;
		}
		return min;
	}
}