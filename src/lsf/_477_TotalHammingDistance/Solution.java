package lsf._477_TotalHammingDistance;

public class Solution {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count_1 = 0;
            for (int j = 0; j < n; j++) {
                count_1 += (nums[j] >> i) & 1;
            }
            ans += count_1 * (n - count_1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().totalHammingDistance(new int[]{0xffffffff, 0}));
        System.out.println(new Solution().totalHammingDistance(new int[]{2, 14, 4}));
    }

}
