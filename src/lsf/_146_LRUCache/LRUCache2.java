package lsf._146_LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 extends LinkedHashMap<Integer, Integer> {

    private int max;

    public LRUCache2(int size) {
        super(16, 0.75f, true);
        max = size;
    }

    @Override
    public Integer get(Object key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > max;
    }
}
