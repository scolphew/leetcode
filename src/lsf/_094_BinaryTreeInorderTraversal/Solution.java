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
		while (p != null || !stack.isEmpty()) { // 阌熻鍖℃嫹阌熸枻鎷烽敓绐栴叏鎷烽敓锟?
			while (p != null) { // 瀵婚敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熼摪镄勮妭纰夋嫹
				stack.push(p);
				p = p.left;
			}
			if (!stack.isEmpty()) { // 阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷疯阌熸枻鎷烽敓鏂ゆ嫹鍓嶆爤阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓鏂ゆ嫹阌熼摪瑙掔殑鑺傜鎷?
				p = stack.pop();
				list.add(p.val); // 阌熸枻鎷烽敓鏂ゆ嫹濯掕瘶镇栵拷阌熺煫鑺傜鎷烽敓楗哄够浼欐嫹阌熸枻鎷烽敓鏂ゆ嫹阌熸枻鎷烽敓锟?
				p = p.right; // 阌熸枻鎷烽敓鏂ゆ嫹阌熸彮鐚存嫹阌熸枻鎷?
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
