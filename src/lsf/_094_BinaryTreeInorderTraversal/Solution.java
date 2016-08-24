package lsf._094_BinaryTreeInorderTraversal;

import lsf._000_base.Print;
import lsf._000_base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) { // 锟角匡拷锟斤拷锟窖拷锟�
			while (p != null) { // 寻锟斤拷锟斤拷锟斤拷锟铰的节碉拷
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) { // 锟斤拷锟斤拷锟斤拷说锟斤拷锟斤拷前栈锟斤拷锟斤拷锟斤拷锟斤拷锟铰角的节碉拷
				p = stack.pop();
				list.add(p.val); // 锟斤拷锟斤拷媒诘悖�锟矫节碉拷锟饺幻伙拷锟斤拷锟斤拷锟斤拷锟�
				p = p.right; // 锟斤拷锟斤拷锟揭猴拷锟斤拷
			}
		}
		return list;
	}
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) { 
				stack.push(p);
				p = p.left;
			}
			else{
				p = stack.pop();
				list.add(p.val); 
				p = p.right; 
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		Print.printList(s.inorderTraversal(root));
		Print.printList(s.inorderTraversal2(root));
	}
}
