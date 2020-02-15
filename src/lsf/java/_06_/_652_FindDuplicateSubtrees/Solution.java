package lsf.java._06_._652_FindDuplicateSubtrees;

import base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();

        lookup(root, map, ans);
        return ans;
    }

    public String lookup(TreeNode node, Map<String, Integer> map, List<TreeNode> ans) {
        if (node == null) return "";
        String serial = node.val + "," + lookup(node.left, map, ans) + "," + lookup(node.right, map, ans);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2)
            ans.add(node);
        return serial;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.findDuplicateSubtrees(
                new TreeNode(3,
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3)),
                        new TreeNode(1,
                                new TreeNode(2),
                                new TreeNode(3))
                )
        );
    }

}
