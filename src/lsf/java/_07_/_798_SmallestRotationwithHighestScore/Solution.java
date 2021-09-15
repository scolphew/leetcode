package lsf.java._07_._798_SmallestRotationwithHighestScore;

public class Solution {
    public int bestRotation(int[] nums) {
        int N = nums.length;
        int[] good = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int l = i + 1;
            int r = (N + 1) - (nums[i] - i);

            good[l]++;
            if (r > N) {
                good[r - N]--;
                good[0]++;
            } else {
                good[r]--;
            }
        }
        int ans = 0;
        int base = 0, max = 0;
        for (int i = 0; i < N; i++) {
            base += good[i];
            if (base > max) {
                ans = i;
                max = base;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.bestRotation(new int[]{1, 3, 0, 2, 4});
        System.out.println(i);
    }
}
