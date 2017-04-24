package lsf._179_LargestNumber;

import java.util.Arrays;

public class Solution {

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (o2, o1) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        if (s[0].charAt(0) == '0')
            return "0";
        for (String ss : s) {
            sb.append(ss);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{1, 2, 3, 45}));
        System.out.println(new Solution().largestNumber(new int[]{121, 12}));
        System.out.println(new Solution().largestNumber(new int[]{1, 2}));
        System.out.println(new Solution().largestNumber(new int[]{0, 0}));
    }
}
