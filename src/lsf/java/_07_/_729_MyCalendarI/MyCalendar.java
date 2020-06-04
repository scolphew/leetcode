package lsf.java._07_._729_MyCalendarI;

public class MyCalendar {
    Node root;

    public MyCalendar() {
    }

    public boolean book(int start, int end) {
        if (root == null) {
            root = new Node(start, end);
            return true;
        }
        Node p = root;
        Node node = new Node(start, end);
        while (true) {
            if (start >= p.right) {
                if (p.rChild == null) {
                    p.rChild = node;
                    return true;
                } else {
                    p = p.rChild;
                }
            } else if (end <= p.left) {
                if (p.lChild == null) {
                    p.lChild = node;
                    return true;
                } else {
                    p = p.lChild;
                }
            } else
                return false;
        }
    }


    class Node {
        int left;
        int right;
        Node lChild;
        Node rChild;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MyCalendar my = new MyCalendar();
        my.book(10, 20);
    }

}
