package lsf.java._331_VerifyPreorderSerializationofaBinaryTree;

import java.util.Stack;

public class Solution2 {
    /**
     * 栈存储树的当前路径，左子树出栈后用#代替，
     */
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        Stack<String> stack = new Stack<>();

        for (String c : s) {
            while (c.equals("#") && !stack.isEmpty() && stack.peek().equals(c)) {
                stack.pop();
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(c);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

}
