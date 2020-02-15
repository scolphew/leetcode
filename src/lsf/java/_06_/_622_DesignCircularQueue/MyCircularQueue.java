package lsf.java._06_._622_DesignCircularQueue;


public class MyCircularQueue {

    int[] data;
    int length;
    int start, end;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        data = new int[k + 1];
        length = k + 1;
        start = 0;
        end = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        data[end] = value;
        end = (end + 1) % length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        start = (start + 1) % length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty())
            return -1;
        return data[start];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty())
            return -1;
        return data[(end - 1 + length) % length];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return start == end;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (end + 1 + length) % length == start;
    }

    public static void main(String[] args) {
        MyCircularQueue s = new MyCircularQueue(3);

        System.out.println(s.enQueue(1));
        System.out.println(s.enQueue(2));
        System.out.println(s.enQueue(3));
        System.out.println(s.enQueue(4));
        System.out.println(s.Rear());
        System.out.println(s.isFull());
        System.out.println(s.deQueue());
        System.out.println(s.enQueue(4));
        System.out.println(s.Rear());
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
        System.out.println(s.deQueue());
    }
}
