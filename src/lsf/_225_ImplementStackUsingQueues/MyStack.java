package lsf._225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("WeakerAccess")
public class MyStack {
	
	public static void main(String[] args) {
		MyStack s=new MyStack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);s.pop();
		s.push(7);s.pop();
		s.push(8);s.pop();s.pop();
		System.out.println(s.top());
	}
	
	Queue<Integer> queue=new LinkedList<Integer>();
	 // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Queue<Integer> newQueue=new LinkedList<Integer>();
        while (queue.size()>1) {
        	newQueue.add(queue.poll());
		}
        queue=newQueue;
    }

    // Get the top element.
    public int top() {
    	Queue<Integer> newQueue=new LinkedList<Integer>();
    	while (queue.size()>1) {
        	newQueue.add(queue.poll());
		}
        int x=queue.poll();
        newQueue.add(x);
        queue=newQueue;
        return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
