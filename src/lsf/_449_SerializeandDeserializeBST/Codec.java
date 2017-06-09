package lsf._449_SerializeandDeserializeBST;

import base.TreeNode;

public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        String l = serialize(root.left);
        String r = serialize(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        if (l != "")
            sb.append("," + l);
        if (r != "")
            sb.append("," + r);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = ("1," + data).split(",");
        int[] i = new int[split.length - 1];
        for (int j = 0; j < i.length; j++) {
            i[j] = Integer.parseInt(split[j + 1]);
        }
        return foo(i, 0, i.length - 1);
    }

    private TreeNode foo(int[] nums, int l, int r) {
        if (l > r)
            return null;
        TreeNode ans = new TreeNode(nums[l]);
        if (l == r) {
            return ans;
        }
        int i = l + 1;
        for (; i < nums.length; i++) {
            if (nums[i] > nums[l])
                break;
        }
        ans.left = foo(nums, l + 1, i - 1);
        ans.right = foo(nums, i, r - 1);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        //t.left.left = new TreeNode(2);
        //t.left.right = new TreeNode(4);
        //t.right.right = new TreeNode(7);
        //System.out.println(new Codec().serialize(t));
        System.out.println(new Codec().deserialize(new Codec().serialize(t)));
        System.out.println(new Codec().deserialize(new Codec().serialize(null)));
    }
}
