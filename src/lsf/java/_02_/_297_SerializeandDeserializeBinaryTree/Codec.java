package lsf.java._02_._297_SerializeandDeserializeBinaryTree;

import base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp != null) {
                q.offer(tmp.left);
                q.offer(tmp.right);
                sb.append(tmp.val);
                sb.append(",");
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode ans = createNode(split[0]);
        q.offer(ans);
        for (int i = 1; i < split.length; ) {
            TreeNode tmp = q.poll();
            tmp.left = createNode(split[i++]);
            tmp.right = createNode(split[i++]);
            if (tmp.left != null)
                q.offer(tmp.left);
            if (tmp.right != null)
                q.offer(tmp.right);
        }
        return ans;
    }

    public TreeNode createNode(String s) {
        if (s.equals("#"))
            return null;
        return new TreeNode(Integer.valueOf(s));
    }


    public static void main(String[] args) {
        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(2);

        Codec codec = new Codec();
        codec.deserialize(codec.serialize(n));
    }

}
