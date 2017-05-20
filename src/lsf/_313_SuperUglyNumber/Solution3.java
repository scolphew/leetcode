package lsf._313_SuperUglyNumber;


public class Solution3 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1)
            return 1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        Num[] q = new Num[primes.length];
        for (int i = 0; i < primes.length; i++) {
            q[i] = new Num(primes[i], 1, primes[i]);
        }
        init(q);
        for (int i = 1; i < n; i++) {
            Num num = q[0];
            ugly[i] = num.val;
            while (q[0].val == ugly[i]) {
                q[0].add(ugly);
                adjust(q, 0);
            }
        }

        return ugly[n - 1];
    }

    void init(Num[] nums) {
        for (int i = 0; i < nums.length / 2 - 1; i++) {
            adjust(nums, i);
        }
    }

    void adjust(Num[] nums, int i) {
        int length = nums.length - 1;
        int lChild = i * 2 + 1;
        int rChild = lChild + 1;
        int min = i;
        if (i <= (length - 1) / 2) {
            if (lChild <= length && nums[lChild].val < nums[min].val)
                min = lChild;
            if (rChild <= length && nums[rChild].val < nums[min].val)
                min = rChild;
            if (min != i) {
                Num tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
                adjust(nums, min);
            }
        }
    }

    class Num {
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

    }

    public static void main(String[] args) {
        System.out.println(new Solution3().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

}
