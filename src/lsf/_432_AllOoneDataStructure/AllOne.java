package lsf._432_AllOoneDataStructure;

import java.util.*;

public class AllOne {

    Map<String, Integer> map;
    TreeMap<Integer, Set<String>> intMap;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
        intMap = new TreeMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (map.containsKey(key)) {
            int count = map.get(key);
            map.put(key, count + 1);
            updateIntMap(key, count, count + 1);
        } else {
            map.put(key, 1);
            updateIntMap(key, 0, 1);
        }
    }

    private void updateIntMap(String key, int f, int t) {
        if (f != 0) {
            intMap.get(f).remove(key);
            if (intMap.get(f).size() == 0)
                intMap.remove(f);
        }
        if (t != 0) {
            if (intMap.containsKey(t))
                intMap.get(t).add(key);
            else {
                Set<String> set = new HashSet<>();
                set.add(key);
                intMap.put(t, set);
            }
        }

    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        if (map.containsKey(key)) {
            int count = map.get(key);
            if (count > 1) {
                map.put(key, count - 1);
            } else {
                map.remove(key);
            }
            updateIntMap(key, count, count - 1);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (map.size() == 0)
            return "";
        return intMap.lastEntry().getValue().iterator().next();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (map.size() == 0)
            return "";
        return intMap.firstEntry().getValue().iterator().next();
    }

    public static void main(String[] args) {
        AllOne s = new AllOne();
        s.inc("1");
        s.inc("1");
        s.inc("2");
        s.inc("2");
        System.out.println(s.getMaxKey());
        System.out.println(s.getMinKey());
        s.dec("2");
        System.out.println(s.getMaxKey());
        System.out.println(s.getMinKey());
    }
}
