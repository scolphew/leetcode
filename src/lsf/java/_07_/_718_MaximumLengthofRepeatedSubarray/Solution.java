package lsf.java._07_._718_MaximumLengthofRepeatedSubarray;

public class Solution {

    public int findLength(int[] A, int[] B) {
        int ans = 0;
        int dp[] = new int[B.length + 1];
        for (int i = 1; i <= B.length; i++) {
            dp[i] = A[0] == B[i - 1] ? 1 : 0;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = B.length; j > 0; j--) {
                dp[j] = A[i] == B[j - 1] ? (dp[j - 1] + 1) : 0;
                ans = Math.max(dp[j], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLength(
                new int[]{1, 2, 3, 2, 1},
                new int[]{3, 2, 1, 4, 7}
        ));
    }

}
