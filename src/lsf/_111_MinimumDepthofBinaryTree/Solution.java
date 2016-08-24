package lsf._111_MinimumDepthofBinaryTree;

import lsf._000_base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("WeakerAccess")
public class Solution {
	/**
	 * 直接从求最大深度复制的代码，加了个叶子节点判返回
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int d = 0;//记录层数
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode tn;
		int is = 1, next = 0;//本层个数和下一层个数
		while ((tn = queue.poll()) != null) {
			is--;
			//下面这个判断是新加的，只要没孩子就可以返回了
			//由于在本层结束的时候层数+1
			//提前跳出要增加一层
			if (tn.left == null && tn.right == null)
				return ++d;
			if (tn.left != null) {
				queue.add(tn.left);
				next++;
			}
			if (tn.right != null) {
				queue.add(tn.right);
				next++;
			}
			if (is == 0) { // 本层结束
				is = next;
				next = 0;
				d++;//每一次在本层结束的时候层数+1
			}
		}
		return 0;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right=new TreeNode(4);
		root.right.right.right=new TreeNode(4);

		System.out.println(s.minDepth(root));
	}
}
