package lsf.java._703_KthLargestElementinaStream;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int size;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        size = k;

        for (int num : nums) {
            add(num);
        }

    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > size)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest x = new KthLargest(3, new int[]{4, 5, 8, 2});
        x.add(3);
        x.add(5);
        x.add(10);
        x.add(9);
        x.add(4);

    }

}
