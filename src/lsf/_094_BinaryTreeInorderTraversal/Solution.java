package lsf._094_BinaryTreeInorderTraversal;

import lsf._000_base.Print;
import lsf._000_base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.pop();
				list.add(p.val);
				p = p.right;
			}
		}
		return list;
	}
	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
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
