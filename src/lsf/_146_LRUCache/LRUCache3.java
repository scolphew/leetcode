package lsf._146_LRUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache3 {

    class Node {
        int k, v;

        public Node(int a, int b) {
            k = a;
            v = b;
        }
    }

    Map<Integer, Node> map;
    LinkedList<Node> list;
    int maxSize;
    int size;

    public LRUCache3(int capacity) {
        maxSize = capacity;
        map = new HashMap<>();
        list = new LinkedList<>();
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            list.remove(n);
            list.add(n);
            return n.v;
        }
        return -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.v = value;
            list.remove(n);
            list.add(n);
        } else if (maxSize == size) {
            map.remove(list.removeFirst().k);
            Node n = new Node(key, value);
            list.add(n);
            map.put(key, n);
        } else {
            Node n = new Node(key, value);
            list.add(n);
            map.put(key, n);
            size++;
        }
    }

    public static void main(String[] args) {
        LRUCache3 c = new LRUCache3(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
    }

}
