package lsf._237_DeleteNodeInaLinkedList;

import lsf._000_base.ListNode;

@SuppressWarnings("WeakerAccess")
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] nums={1,2,3,4,5,6,7};
		ListNode ln= ListNode.scanf(nums);
		s.deleteNode(ln);
		ListNode.print(ln);
	}
	
	/**
	 *  Write a function to delete a node (except the tail) in a singly linked list, 
	 *  given only access to that node.
	 *  Supposed the linked list is 1 -> 2 -> 3 -> 4 and 
	 *  you are given the third node with value 3,
	 *  the linked list should become 1 -> 2 -> 4 after calling your function. 
	 * @param node
	 */
	public void deleteNode(ListNode node) {
		node=node.next;
    }
}

