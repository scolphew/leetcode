package lsf.java._396_RotateFunction;

public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int tmp = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            tmp += i * A[i];
        }
        int ans = tmp;
        for (int i = 0; i < n - 1; i++) {
            tmp = tmp + sum - A[n - 1 - i] * n;
            if (tmp > ans)
                ans = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(new Solution().maxRotateFunction(new int[]{}));
    }
}
