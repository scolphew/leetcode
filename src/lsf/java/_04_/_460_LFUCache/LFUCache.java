package lsf.java._04_._460_LFUCache;

import java.util.*;

public class LFUCache {

    class Node {
        int key, value, count;
        Node pre, next;

        public Node(int k, int v) {
            key = k;
            value = v;
            count = 1;
        }

        @Override
        public String toString() {
            return String.format("%d->%d", key, value);
        }

        /**
         * 更新value
         *
         * @return 原次数
         */
        public int update(int value) {
            this.value = value;
            return count++;
        }
    }

    Map<Integer, Node> map;
    Map<Integer, LinkedHashSet<Node>> level;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.level = new LinkedHashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        if (capacity == 0)
            return -1;
        if (map.containsKey(key)) {
            Node n = map.get(key);

            level.get(n.count++).remove(n);
            if (!level.containsKey(n.count)) {
                level.put(n.count, new LinkedHashSet<>());
            }
            level.get(n.count).add(n);
            return n.value;
        }
        return -1;
    }

    private void removeFirst() {
        for (Map.Entry<Integer, LinkedHashSet<Node>> entry : level.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                Node n = entry.getValue().iterator().next();
                map.remove(n.key);
                entry.getValue().remove(n);
                return;
            }
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node n = map.get(key); //结点
            int count = n.update(value);

            // 将该节点移动到下一层
            level.get(count++).remove(n);
            if (!level.containsKey(count)) {
                level.put(count, new LinkedHashSet<>());
            }
            level.get(count).add(n);
        } else {
            if (this.size == this.capacity) {
                //超标
                removeFirst();
            } else {
                this.size++;
            }

            //没有这个key,需要修改
            Node n = new Node(key, value);
            map.put(key, n);
            //放入
            if (!level.containsKey(1)) {
                level.put(1, new LinkedHashSet<>());
            }
            level.get(1).add(n);
        }
    }

    public static void main(String[] args) {
        LFUCache c = new LFUCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        System.out.println(c.map);
        System.out.println(c.level);
    }
}
