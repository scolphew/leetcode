package lsf.java._01_._107_BinaryTreeLevelOrderTraversalII;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author scolphew
 */
public class Solution {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode t = q.poll();
                if (t.left != null) {
                    q.add(t.left);
                }
                if (t.right != null) {
                    q.add(t.right);
                }
                l.add(t.val);
            }
            lst.add(0, l);
        }
        return lst;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List l = s.levelOrderBottom(root);
        System.out.println(l);
    }
}
