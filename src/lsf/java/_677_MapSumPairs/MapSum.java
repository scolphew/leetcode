package lsf.java._677_MapSumPairs;

import java.util.HashMap;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。
 * 字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 */
public class MapSum {
    HashMap<String, Integer> map;
    TrieNode root;

    public MapSum() {
        map = new HashMap();
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
            cur.score += delta;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children[c - 'a'];
            if (cur == null)
                return 0;
        }
        return cur.score;
    }

    public static void main(String[] args) {
        MapSum s = new MapSum();

        s.insert("app", 3);
        s.insert("apple", 2);
        System.out.println(s.sum("ap"));
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int score;

    @Override
    public String toString() {
        return super.toString() + "," + score;
    }
}
