package lsf.java._07_._705_DesignHashSet;

public class MyHashSet {
    int[] data;
    int L = 15017;

    /**
     * 默认-1，表示未访问
     */
    public MyHashSet() {
        data = new int[L];
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }

    public void add(int key) {
        int i = key % L;

        while (data[i] != -1 && data[i] != -2 && data[i] != key) {
            i++;
            i %= L;
        }
        data[i] = key;

    }

    /**
     * -2 删除过
     *
     * @param key
     */
    public void remove(int key) {
        int i = key % L;
        while (data[i] != -1 && data[i] != key) {
            i++;
            i %= L;
        }
        if (data[i] == key)
            data[i] = -2;

    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = key % L;
        while (data[i] != -1 && data[i] != key) {
            i++;
            i %= L;
        }
        return data[i] == key;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));

    }

}
