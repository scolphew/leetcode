package lsf.java._01_._104_MaximumDepthOfBinaryTree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;



/**
 * @author scolphew
 */
@SuppressWarnings("WeakerAccess")
public class Solution {

	public static void main(String[] args) {
		
		Solution s=new Solution();
		TreeNode root=new TreeNode(1);
		
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(5);
		//root.right.right=new TreeNode(4);
		
		
		System.out.println(s.maxDepth(root));
	}

	private int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		int d=0;
		Queue<TreeNode> queue= new LinkedList<>();
		queue.add(root);
		TreeNode tn;
		int is=1,next=0;
		while((tn= queue.poll())!=null ){
			is--;
			if(tn.left!=null){
				queue.add(tn.left);
				next++;
			}
			if(tn.right!=null){
				queue.add(tn.right);
				next++;
			}
			if(is==0){  //本层结束   
				is=next;
				next=0;
				d++;
			}
		}
		return d;
	}
}
