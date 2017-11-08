package lsf.java._155_MinStack;


@SuppressWarnings("ALL")
public class MinStack2 {
	
	public static void main(String[] args) {
		push(85);push(-99);push(67);getMin();push(-27);push(61);push(-97);push(-27);push(35);top();push(99);push(-66);getMin();push(-89);getMin();push(4);push(-70);getMin();push(52);top();push(54);getMin();push(94);push(-41);push(-75);push(-32);getMin();push(5);push(29);top();push(-78);push(-74);getMin();pop();getMin();push(-58);push(-44);getMin();getMin();push(-64);getMin();pop();push(-45);push(-99);push(-27);getMin();push(-96);getMin();getMin();getMin();pop();getMin();push(26);push(-58);getMin();top();getMin();push(25);getMin();getMin();getMin();getMin();push(33);getMin();getMin();getMin();push(71);getMin();push(-62);getMin();push(-78);getMin();getMin();getMin();getMin();pop();getMin();push(-30);getMin();getMin();push(85);push(-15);pop();push(-40);getMin();push(72);top();top();push(18);push(59);getMin();pop();getMin();push(-59);top();push(10);getMin();push(9);getMin();getMin();
		System.out.println(getMin());
	}

	static ListNode list;
	static ListMin min;
	
	public static void push(int x) {
		if(list==null){
			list=new ListNode(x);
			min=new ListMin(x);
		}
		else{
			//加入节点
			ListNode p=list;
			list =new ListNode(x);
			list.next=p;
			//更改最小值
			if(x==min.val){
				min.count++;
			}else if (x<min.val) {
				ListMin q=new ListMin(x);
				q.next=min;
				min=q;
			}
		}
	}

	public static void pop() {
		if(list!=null){
			int x=list.val;
			list=list.next;
			//更改最小值
			if( x==min.val ){
				if(min.count==1){
					min=min.next;
				}else{
					min.count--;
				}
			}
		}
	}

	public static int top() {
		return list.val;
	}

	public static int getMin() {
		return min.val;
	}
}
class ListMin{
	final int val;
	int count;
	ListMin next;
	public ListMin(int i) {
		val=i;
		count=1;
	}
}
class ListNode{
	final int val;
	ListNode next;
	public ListNode(int i) {
		val=i;
	}
}
