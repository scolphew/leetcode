package lsf._260_SingleNumberIII;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // diff为两个只出现一次的a,b的异或
        diff &= -diff; //lowbit 获取最低位的1
        //则，a和b在lowbit位的数必然不同，则通过一位,将所有的数分为两组，然后按只有一种的求法
        int[] ans = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(2 ^ 0);
    }

}
