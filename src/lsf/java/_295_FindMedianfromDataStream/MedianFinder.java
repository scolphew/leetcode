package lsf.java._295_FindMedianfromDataStream;

import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Long> small = new PriorityQueue(),
            large = new PriorityQueue();

    public void addNum(int num) {
        large.offer((long) num);
        small.offer(-large.poll());
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }


}
