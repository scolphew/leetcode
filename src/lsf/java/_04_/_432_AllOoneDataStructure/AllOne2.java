package lsf.java._04_._432_AllOoneDataStructure;

import java.util.HashMap;
import java.util.HashSet;

public class AllOne2 {
    /**
     * Initialize your data structure here.
     */

    private class Bucket {
        Bucket pre;
        Bucket next;
        int index;
        HashSet<String> keys;

        public Bucket(int index) {
            this.index = index;
            keys = new HashSet<>();
        }
    }

    HashMap<String, Bucket> map;
    Bucket head = new Bucket(-1);
    Bucket tail = new Bucket(-1);

    public AllOne2() {
        map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    private void insertNextBucket(Bucket pre, int index) {
        Bucket cur = new Bucket(index);
        pre.next.pre = cur;
        cur.next = pre.next;
        pre.next = cur;
        cur.pre = pre;
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next.index != 1) {
                insertNextBucket(head, 1);
            }
            head.next.keys.add(key);
            map.put(key, head.next);
        } else {
            Bucket pre = map.get(key);
            pre.keys.remove(key);
            if (pre.next.index != pre.index + 1) {
                insertNextBucket(pre, pre.index + 1);
            }
            pre.next.keys.add(key);
            map.put(key, pre.next);

            if (pre.keys.size() == 0) {
                removeBucket(pre);
            }
        }
    }


    private void insertPreBucket(Bucket cur, int index) {
        Bucket pre = new Bucket(index);
        cur.pre.next = pre;
        pre.pre = cur.pre;
        pre.next = cur;
        cur.pre = pre;

    }

    private void removeBucket(Bucket cur) {
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {

        if (!map.containsKey(key)) {
            return;
        }
        Bucket cur = map.get(key);
        cur.keys.remove(key);
        if (cur.index != 1 && cur.pre.index != cur.index - 1) {
            insertPreBucket(cur, cur.index - 1);
            cur.pre.keys.add(key);
            map.put(key, cur.pre);
        } else if (cur.index != 1) {
            cur.pre.keys.add(key);
            map.put(key, cur.pre);
        } else if (cur.index == 1) {
            map.remove(key);
        }

        if (cur.keys.size() == 0) {
            removeBucket(cur);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return tail.pre == head ? "" : tail.pre.keys.iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        //return head.next.keys.iterator().next();
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }


}
