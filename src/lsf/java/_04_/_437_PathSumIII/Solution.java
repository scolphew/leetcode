package lsf.java._04_._437_PathSumIII;

import base.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        return traverse(root, 0, sum, map);
    }

    private int traverse(TreeNode node, int sum, int target, Map<Integer, Integer> counts) {
        if (node == null) return 0;

        sum += node.val;
        int count = counts.getOrDefault(sum - target, 0);

        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        count += traverse(node.left, sum, target, counts);
        count += traverse(node.right, sum, target, counts);
        counts.put(sum, counts.get(sum) - 1);

        return count;
    }


}
