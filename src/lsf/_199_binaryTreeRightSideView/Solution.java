package lsf._199_binaryTreeRightSideView;
import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(5);
		root.right.right=new TreeNode(4);
		System.out.println(rightSideView(root));
	}
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> l=new ArrayList<Integer>();
		while(root!=null){
			l.add(root.val);
			if(root.right!=null)
				root=root.right;
			else
				root=root.left;
		}
		return l;
	}

}
