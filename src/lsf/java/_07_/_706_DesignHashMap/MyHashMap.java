package lsf.java._07_._706_DesignHashMap;

public class MyHashMap {

    int[][] data;
    int L = 15017;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        data = new int[L][2];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = -1;
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = key % L;

        while (data[i][0] != -1 && data[i][0] != -2 && data[i][0] != key) {
            i++;
            i %= L;
        }
        data[i][0] = key;
        data[i][1] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = key % L;
        while (data[i][0] != -1 && data[i][0] != key) {
            i++;
            i %= L;
        }
        if (data[i][0] == key)
            return data[i][1];
        else
            return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int i = key % L;
        while (data[i][0] != -1 && data[i][0] != key) {
            i++;
            i %= L;
        }
        if (data[i][0] == key)
            data[i][0] = -2;
    }

}
