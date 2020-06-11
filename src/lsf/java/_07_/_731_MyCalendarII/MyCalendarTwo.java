package lsf.java._07_._731_MyCalendarII;


import java.util.TreeMap;

public class MyCalendarTwo {

    TreeMap<Integer, Integer> delta;

    public MyCalendarTwo() {
        delta = new TreeMap();
    }

    public boolean book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0;
        for (int d : delta.values()) {
            active += d;
            if (active >= 3) {
                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                if (delta.get(start) == 0)
                    delta.remove(start);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        calendar.book(1, 100);
        calendar.book(5, 96);
        calendar.book(3, 98);
    }

}
