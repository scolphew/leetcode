package lsf.java._483_SmallestGoodBase;

import java.math.BigInteger;

public class Solution {
    public String smallestGoodBase(String nn) {
        long n = Long.parseLong(nn);
        BigInteger nnn = new BigInteger(nn);
        long start = (long) (Math.log(n) / Math.log(2));
        for (long k = start; k >= 2; k--) {
            BigInteger a = new BigInteger(String.valueOf((long) Math.pow(n, 1.0 / k)));
            if ((a.pow((int) (k + 1)).subtract(BigInteger.ONE)).divide(a.subtract(BigInteger.ONE)).equals(nnn))
                return String.valueOf(a);
        }
        return String.valueOf(n - 1);
    }

    public static void main(String[] args) {

        System.out.println(new Solution().smallestGoodBase("13"));
        System.out.println(new Solution().smallestGoodBase("4681"));
        System.out.println(new Solution().smallestGoodBase("1000000000000000000"));
        System.out.println(new Solution().smallestGoodBase("14919921443713777"));
    }

}
