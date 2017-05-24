package lsf._331_VerifyPreorderSerializationofaBinaryTree;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        int diff = 1;
        for (String node : s) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
}
