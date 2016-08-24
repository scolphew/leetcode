package lsf._232_ImplementQueueUsingStacks;

import java.util.Stack;

public class MyQueue {
	boolean isInQueue =true;
	Stack<Integer> stack=new Stack<Integer>();
	// Push element x to the back of queue.
    public void push(int x) {
        if(isInQueue){
        	stack.push(x);
        }else{
        	change();
        	stack.push(x);
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(isInQueue){
    		change();
    		stack.pop();
    	}else{
    		stack.pop();
    	}
        
    }

    // Get the front element.
    public int peek() {
    	if(isInQueue){
    		change();
    		return stack.peek();
    	}else{
    		return stack.peek();
    	}
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
    private void change(){
    	Stack<Integer> newStack=new Stack<Integer>();
    	while(!stack.isEmpty())
    		newStack.push(stack.pop());
    	stack=newStack;
    	isInQueue=!isInQueue;
    }
}
