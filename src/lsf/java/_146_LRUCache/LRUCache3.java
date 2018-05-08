package lsf.java._146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {

    class Node {
        int k, v;
        Node pre, next;

        public Node(int a, int b) {
            k = a;
            v = b;
        }

        @Override
        public String toString() {
            return String.format("%d->%d", k, v);
        }
    }

    Map<Integer, Node> map;
    Node head;
    int capacity;
    int size;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.head.next = head;
        this.head.pre = head;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insertLast(n);
            return n.v;
        }
        return -1;

    }

    /**
     * 把结点n插入到最后位置
     */
    private void insertLast(Node n) {
        n.next = head;
        n.pre = head.pre;
        head.pre = n;
        n.pre.next = n;
    }

    private void update(Node n, int val) {
        n.v = val;
        remove(n);
        insertLast(n);
    }

    private void removeFirst() {
        if (size > 0) {
            map.remove(remove(head.next));
        }
    }

    /**
     * 移除链表上的该节点
     */
    private int remove(Node n) {
        n.next.pre = n.pre;
        n.pre.next = n.next;
        return n.k;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            update(map.get(key), value);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            insertLast(n);
            size++;
            if (size > capacity) {
                removeFirst();
            }

        }

    }

    public static void main(String[] args) {
        LRUCache3 c = new LRUCache3(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
    }

}
