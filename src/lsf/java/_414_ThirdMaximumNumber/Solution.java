package lsf.java._414_ThirdMaximumNumber;

public class Solution {
    public int thirdMax(int[] nums) {
        long max1 = Long.MIN_VALUE;
        long max2 = max1;
        long max3 = max1;
        for (Integer n : nums) {
            if (n == max1 || n == max2 || n == max3)
                continue;
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
        }
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().thirdMax(new int[]{1, 1, Integer.MIN_VALUE}));
        System.out.println(new Solution().thirdMax(new int[]{2, 2, 3, 1}));
    }

}
