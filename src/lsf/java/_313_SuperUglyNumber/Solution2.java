package lsf.java._313_SuperUglyNumber;

import java.util.Arrays;

public class Solution2 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] res = new int[n];
        int[] idx = new int[len];
        int[] prod = new int[len];
        Arrays.fill(prod, 1);
        int nxval = 1;
        for (int i = 0; i < n; i++) {
            res[i] = nxval;
            nxval = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (prod[j] == res[i])//the prime used in lasted round
                    prod[j] = res[idx[j]++] * primes[j];
                nxval = Math.min(nxval, prod[j]);
            }
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

}
