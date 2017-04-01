package lsf._145_BinaryTreePostorderTraversal;

import base.Print;
import base.TreeNode;

import java.util.*;

@SuppressWarnings("WeakerAccess")
public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Map<TreeNode, Boolean> map=new HashMap<TreeNode, Boolean>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p=root;
		while (p != null || !stack.isEmpty()) { 
			while (p != null) { 
				if(!map.containsKey(p))
					if(p.left==null && p.right==null){
						list.add(p.val);
						map.put(p, true);
						System.out.println(p.val);
					}
					else{
						stack.push(p);
				}
				p = p.left;
			}
			if (!stack.isEmpty()) {
				p = stack.peek(); 
				
				
				if(p.right!=null){
					if(map.containsKey(p.right)){
						list.add(p.val);
						stack.pop();
						map.put(p, true);
						System.out.println(p.val);
					}else{
						p=p.right;
					}
				}else{
					list.add(p.val);
					stack.pop();
					map.put(p, true);
				}
			}
		}
		return list;
	}

	
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p=root,r=null;
		while(p!=null || !stack.isEmpty()){
			if(p!=null){
				stack.push(p);
				p=p.left;
			}else{
				p=stack.peek();
				if(p.right!=null && p.right !=r){
					p=p.right;
					stack.push(p);
					p=p.left;
				}else{
					stack.pop();
					list.add(p.val);
					r=p;
					p=null;
				}
			}
		}
		return list;
		
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(3);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		Print.printList(s.postorderTraversal(root));
		Print.printList(s.postorderTraversal2(root));
	}
}
