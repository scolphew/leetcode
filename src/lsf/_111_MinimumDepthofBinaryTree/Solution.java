package lsf._111_MinimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import lsf._000_base.TreeNode;

public class Solution {
	/**
	 * ֱ�Ӵ��������ȸ��ƵĴ��룬���˸�Ҷ�ӽڵ��з���
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int d = 0;//��¼����
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode tn;
		int is = 1, next = 0;//�����������һ�����
		while ((tn = queue.poll()) != null) {
			is--;
			//��������ж����¼ӵģ�ֻҪû���ӾͿ��Է�����
			//�����ڱ��������ʱ�����+1
			//��ǰ����Ҫ����һ��
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
			if (is == 0) { // �������
				is = next;
				next = 0;
				d++;//ÿһ���ڱ��������ʱ�����+1
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
