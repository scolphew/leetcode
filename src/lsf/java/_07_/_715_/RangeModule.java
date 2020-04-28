package lsf.java._07_._715_;

class RangeModule {

    public class TreeNode {
        public int left;
        public int right;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    TreeNode root;


    public void addRange(int left, int right) {
        root = addRange(root, left, right);
    }

    private TreeNode addRange(TreeNode root, int left, int right) {
        if (left >= right)
            return root;
        if (root == null)
            return new TreeNode(left, right);
        if (left >= root.right) {
            root.rightChild = addRange(root.rightChild, left, right);
        } else if (right <= root.left) {
            root.leftChild = addRange(root.leftChild, left, right);
        } else {
            root.leftChild = addRange(root.leftChild, left, root.left);
            root.rightChild = addRange(root.rightChild, root.right, right);
        }
        return root;
    }

    public void removeRange(int left, int right) {
        root = removeRange(root, left, right);
    }

    public TreeNode removeRange(TreeNode root, int left, int right) {
        if (root == null) {
            return root;
        }
        if (left >= right) {
            return root;
        }

        if (left >= root.right) {
            root.rightChild = removeRange(root.rightChild, left, right);
        } else if (right <= root.left) {
            root.leftChild = removeRange(root.leftChild, left, right);
        } else {
            root.leftChild = removeRange(root.leftChild, left, root.left);
            root.leftChild = addRange(root.leftChild, root.left, left);

            root.rightChild = removeRange(root.rightChild, root.right, right);
            root.rightChild = addRange(root.rightChild, right, root.right);
            root = rebalance(root);
        }
        return root;
    }

    private TreeNode rebalance(TreeNode root) {
        if (root == null)
            return null;
        if (root.leftChild == null) {
            return root.rightChild;
        }

        TreeNode p = root, c = root.leftChild;// c!=null
        while (c.rightChild != null) {
            p = c;
            c = c.rightChild;
        }

        if (c == p.leftChild) {
            c.rightChild = p.rightChild;
        } else {
            p.rightChild = c.leftChild;
            c.leftChild = root.leftChild;
            c.rightChild = root.rightChild;
        }
        return c;
    }

    public boolean queryRange(int left, int right) {
        return queryRange(root, left, right);
    }

    public boolean queryRange(TreeNode root, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (left >= root.right) {
            return queryRange(root.rightChild, left, right);
        } else if (right <= root.left) {
            return queryRange(root.leftChild, left, right);
        } else {
            return queryRange(root.leftChild, left, root.left) && queryRange(root.rightChild, root.right, right);
        }
    }
}