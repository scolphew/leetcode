package lsf.java._01_._190_ReverseBits;

public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while (i-- > 0) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }


    public static void main(String[] args) {
        int b = 43261596;
        b = new Solution().reverseBits(b);
        System.out.println(b);
    }
}
