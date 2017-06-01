package lsf._384_ShuffleanArray;

import base.Print;

import java.util.Random;

public class Solution {
    private int[] nums;
    private Random r;
    private int[] tmp;

    public Solution(int[] nums) {
        this.nums = nums;
        tmp = new int[nums.length];
        r = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int t = r.nextInt(i + 1);
            tmp[i] = tmp[t];
            tmp[t] = nums[i];
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        Solution solution = new Solution(ints);
        Print.print(solution.shuffle());
        Print.print(solution.shuffle());
        Print.print(solution.shuffle());
        Print.print(solution.shuffle());
    }


}
