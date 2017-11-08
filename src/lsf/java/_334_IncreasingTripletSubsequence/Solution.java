package lsf.java._334_IncreasingTripletSubsequence;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = a;
        for (int num : nums) {
            if (num <= a) a = num;
            else if (num <= b) b = num;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new Solution().increasingTriplet(new int[]{1, 1, 1}));
        System.out.println(new Solution().increasingTriplet(new int[]{1, 1, 2}));
    }
}
