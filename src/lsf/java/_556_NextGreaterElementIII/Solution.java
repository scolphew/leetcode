package lsf.java._556_NextGreaterElementIII;

import java.util.Arrays;

public class Solution {


    public int nextGreaterElement(int n) {
        char[] number = String.valueOf(n).toCharArray();

        int i, j;
        for (i = number.length - 1; i > 0; i--)
            if (number[i - 1] < number[i])
                break;

        if (i == 0)
            return -1;

        char x = number[i - 1];

        int left = i, right = number.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (number[mid] <= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        number[i - 1] = number[--right];
        number[right] = x;

        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextGreaterElement(1287651));
    }
}
