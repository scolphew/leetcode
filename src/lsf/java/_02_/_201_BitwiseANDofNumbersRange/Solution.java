package lsf.java._02_._201_BitwiseANDofNumbersRange;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n)
            n = n & (n - 1);
        return n;

    }

    public static void main(String[] args) {
        int k = 5;
        for (int i = 0; i < 10; i++) {
            System.out.print(i+"   ");
            System.out.println((i & (i - 1)));
        }
    }
}
