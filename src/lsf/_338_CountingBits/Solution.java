package lsf._338_CountingBits;

import base.Print;

public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        int i = 1;
        while (i <= num) {
            for (int j = 0; j < i && j + i <= num; j++) {
                ans[i + j] = 1 + ans[j];
            }
            i += i;
        }
        return ans;
    }

    public int[] countBits2(int num) {
        //dynaminc programming and bit manipulation
        int[] cnt = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            cnt[i] = cnt[i / 2] + i % 2;
        }
        return cnt;
    }


    public static void main(String[] args) {
        Print.print(new Solution().countBits(0));
        Print.print(new Solution().countBits(1));
        Print.print(new Solution().countBits(2));
        Print.print(new Solution().countBits(3));
        Print.print(new Solution().countBits(4));
    }

}
