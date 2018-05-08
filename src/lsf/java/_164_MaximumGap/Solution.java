package lsf.java._164_MaximumGap;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        int gap = (max - min) / (nums.length - 1);
        if (gap == 0) gap++;
        int len = (max - min) / gap + 1;
        int[] bucketsMIN = new int[len];
        int[] bucketsMAX = new int[len];
        for (int i : nums) {
            int idx = (i - min) / gap;
            if (i > bucketsMAX[idx])
                bucketsMAX[idx] = i;
            if (bucketsMIN[idx] == 0 || i < bucketsMIN[idx])
                bucketsMIN[idx] = i;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (res < bucketsMIN[i] - min)
                res = bucketsMIN[i] - min;
            if (bucketsMIN[i] != 0)
                min = bucketsMAX[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumGap(new int[]{1, 2, 3, 4, 9}));
        System.out.println(s.maximumGap(new int[]{1, 1, 1}));
    }
}
