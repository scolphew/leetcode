package lsf._330_PatchingArray;

public class Solution {
    public int minPatches(int[] nums, int n) {
        int i = 0;
        int ans = 0;
        long canTo = 0;
        while (canTo < n) {
            if (i < nums.length) {
                if (canTo + 1 == nums[i]) {
                    canTo = canTo * 2 + 1;
                    i++;
                } else if (canTo + 1 < nums[i]) {
                    //System.out.println(canTo + 1);  添加canTo+1
                    ans++;
                    canTo = canTo * 2 + 1;
                } else {
                    canTo += nums[i];
                    i++;
                }
            } else {
                //System.out.println(canTo + 1);//添加canTo+1
                canTo = canTo * 2 + 1;
                ans++;
            }
        }
        return ans;
    }


    public int foo(int[] nums, int n) {
        long max = 0;
        int res = 0;
        for (int i = 0; max < n; ) {
            if (i >= nums.length || max < nums[i] - 1) {
                max += max + 1;
                res++;
            } else {
                max += nums[i];
                i++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        new Solution().minPatches(new int[]{3}, 6);
    }
}
