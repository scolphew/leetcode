package lsf._381_InsertDeleteGetRandomO1Duplicatesallowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class RandomizedCollection {
    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    java.util.Random rand = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean flag = map.containsKey(val);
        if (!flag)
            map.put(val, new LinkedHashSet<>());
        map.get(val).add(list.size());
        list.add(val);
        return !flag;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int tmp = map.get(val).iterator().next();
            map.get(val).remove(tmp);
            if (tmp < list.size() - 1) {
                int lastone = list.get(list.size() - 1);
                list.set(tmp, lastone);
                map.get(lastone).remove(list.size() - 1);
                map.get(lastone).add(tmp);
            }
            list.remove(list.size() - 1);
            if (map.get(val).isEmpty())
                map.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection s = new RandomizedCollection();
        s.insert(1);
        s.insert(1);
        s.insert(2);
        s.insert(1);
        s.insert(2);
        s.insert(2);

        s.remove(1);
        s.remove(2);
        s.remove(2);
        s.remove(2);

        s.getRandom();
    }

}
