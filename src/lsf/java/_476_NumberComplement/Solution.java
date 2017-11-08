package lsf.java._476_NumberComplement;

public class Solution {

    public int findComplement(int num) {
        int tmp = num;
        int n = 1;
        while (tmp >> 1 > 0) {
            tmp >>= 1;
            n++;
        }
        return ~num & 0xffffffff >>> (32 - n);
    }


    public int foo(int num) {
        int n = 1;
        while (n < num)
            n = (n << 1) | 1;
        return n - num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
        //System.out.println(new Solution().findComplement(7));
        //System.out.println(new Solution().findComplement(8));
    }

}
