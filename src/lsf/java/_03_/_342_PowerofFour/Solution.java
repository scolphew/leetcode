package lsf.java._03_._342_PowerofFour;

public class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
    }

    public static void main(String[] args) {
        for (long i = 4; i < Integer.MAX_VALUE; i *= 4) {
            System.out.println(i);
            System.out.println(Long.toBinaryString(i));
        }
    }
}
