package lsf._380_InsertDeleteGetRandom;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {

    //插入删除随机获取，O(1)复杂度
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    java.util.Random rand = new java.util.Random();


    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            int size = list.size();
            map.put(val, size);
            list.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int loc = map.get(val);
            if (loc < list.size() - 1) {
                int last = list.get(list.size() - 1);
                list.set(loc, last);
                map.put(last, loc);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}
