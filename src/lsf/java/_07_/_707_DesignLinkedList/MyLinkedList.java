package lsf.java._07_._707_DesignLinkedList;


public class MyLinkedList {

    private class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            prev.next = this;
            next.prev = this;
        }

        public void del() {
            prev.next = next;
            next.prev = prev;
        }
    }

    int size;
    Node first;
    Node last;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        first = new Node(0);
        last = new Node(0);
        first.next = last;
        last.prev = first;
    }


    public Node getNode(int index) {
        if (index < (size >>> 1)) {
            Node x = first.next;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node x = last.prev;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return getNode(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        new Node(val, first, first.next);
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        new Node(val, last.prev, last);
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        if (index < (size >>> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            new Node(val, x, x.next);
            size++;
        } else {
            Node x = last;
            for (int i = size; i > index; i--) {
                x = x.prev;
            }
            new Node(val, x.prev, x);
            size++;
        }
    }


    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        getNode(index).del();
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
