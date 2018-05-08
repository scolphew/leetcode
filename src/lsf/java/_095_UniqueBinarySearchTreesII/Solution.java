package lsf.java._095_UniqueBinarySearchTreesII;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出指定大小所有结构的二叉搜索树
 *
 * @author scolphew
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();

        return generateTrees(n, 1);
    }

    List<TreeNode> generateTrees(int n, int begin) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 1) {
            list.add(new TreeNode(1 + begin - 1));
            return list;
        }

        // 根节点为最小值
        for (TreeNode treeNode : generateTrees(n - 1, begin + 1)) {
            TreeNode t_1 = new TreeNode(begin);
            t_1.right = treeNode;
            list.add(t_1);
        }

        for (int i = 2; i < n; i++) {
            for (TreeNode left : generateTrees(i - 1, begin)) {
                for (TreeNode right : generateTrees(n - i, i + begin)) {
                    TreeNode t_i = new TreeNode(begin + i - 1);
                    t_i.left = left;
                    t_i.right = right;
                    list.add(t_i);
                }
            }
        }

        // 根节点为最大值
        for (TreeNode treeNode : generateTrees(n - 1, begin)) {
            TreeNode t_n = new TreeNode(n + begin - 1);
            t_n.left = treeNode;
            list.add(t_n);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<TreeNode> list = s.generateTrees(4);
        for (TreeNode treeNode : list) {
            System.out.println(treeNode);
        }
    }

}

