package lsf.java._03_._313_SuperUglyNumber;

import java.util.PriorityQueue;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];

        PriorityQueue<Num> q = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++)
            q.add(new Num(primes[i], 1, primes[i]));
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            Num num = q.peek();
            ugly[i] = num.val;
            while (q.peek().val == ugly[i]) {
                q.offer(q.poll().add(ugly));
            }
        }
        return ugly[n - 1];
    }

    class Num implements Comparable<Num> {
        int val;
        int idx;
        int p;

        public Num(int val, int idx, int p) {
            this.val = val;
            this.idx = idx;
            this.p = p;
        }

        Num add(int[] ugly) {
            val = p * ugly[idx++];
            return this;
        }

        @Override
        public String toString() {
            return String.format("%d(%d)", val, p);
        }

        @Override
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
