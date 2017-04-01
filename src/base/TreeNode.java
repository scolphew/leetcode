package base;
public class TreeNode {
    @SuppressWarnings("CanBeFinal")
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return new Integer(val).toString();
    }
}
